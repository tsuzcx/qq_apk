package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class bhw
  extends com.tencent.mm.cd.a
{
  public LinkedList<bkn> MFx;
  public String SQm;
  public int SRZ;
  public b SSl;
  public int SSm;
  public boolean SSn;
  public long SSo;
  public long feedId;
  public int priority;
  public int tnN;
  public int type;
  
  public bhw()
  {
    AppMethodBeat.i(184209);
    this.MFx = new LinkedList();
    AppMethodBeat.o(184209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184210);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.priority);
      paramVarArgs.aY(2, this.type);
      if (this.SSl != null) {
        paramVarArgs.c(3, this.SSl);
      }
      paramVarArgs.e(4, 8, this.MFx);
      if (this.SQm != null) {
        paramVarArgs.f(5, this.SQm);
      }
      paramVarArgs.aY(6, this.tnN);
      paramVarArgs.aY(7, this.SRZ);
      paramVarArgs.aY(8, this.SSm);
      paramVarArgs.co(9, this.SSn);
      paramVarArgs.bm(100, this.feedId);
      paramVarArgs.bm(101, this.SSo);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.priority) + 0 + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.SSl != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SSl);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.MFx);
      paramInt = i;
      if (this.SQm != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SQm);
      }
      i = g.a.a.b.b.a.bM(6, this.tnN);
      int j = g.a.a.b.b.a.bM(7, this.SRZ);
      int k = g.a.a.b.b.a.bM(8, this.SSm);
      int m = g.a.a.b.b.a.gL(9);
      int n = g.a.a.b.b.a.p(100, this.feedId);
      int i1 = g.a.a.b.b.a.p(101, this.SSo);
      AppMethodBeat.o(184210);
      return paramInt + i + j + k + (m + 1) + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MFx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bhw localbhw = (bhw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localbhw.priority = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localbhw.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localbhw.SSl = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bkn localbkn = new bkn();
          if ((localObject != null) && (localObject.length > 0)) {
            localbkn.parseFrom((byte[])localObject);
          }
          localbhw.MFx.add(localbkn);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localbhw.SQm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 6: 
        localbhw.tnN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184210);
        return 0;
      case 7: 
        localbhw.SRZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184210);
        return 0;
      case 8: 
        localbhw.SSm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(184210);
        return 0;
      case 9: 
        localbhw.SSn = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(184210);
        return 0;
      case 100: 
        localbhw.feedId = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(184210);
        return 0;
      }
      localbhw.SSo = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhw
 * JD-Core Version:    0.7.0.1
 */