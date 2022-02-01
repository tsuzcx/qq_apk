package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhc
  extends com.tencent.mm.cd.a
{
  public LinkedList<Long> RPH;
  public long UHj;
  public int UHk;
  public SnsObject UHl;
  
  public fhc()
  {
    AppMethodBeat.i(260118);
    this.RPH = new LinkedList();
    AppMethodBeat.o(260118);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.UHj);
      paramVarArgs.aY(2, this.UHk);
      if (this.UHl != null)
      {
        paramVarArgs.oE(3, this.UHl.computeSize());
        this.UHl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 3, this.RPH);
      AppMethodBeat.o(260119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.UHj) + 0 + g.a.a.b.b.a.bM(2, this.UHk);
      paramInt = i;
      if (this.UHl != null) {
        paramInt = i + g.a.a.a.oD(3, this.UHl.computeSize());
      }
      i = g.a.a.a.c(4, 3, this.RPH);
      AppMethodBeat.o(260119);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RPH.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(260119);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fhc localfhc = (fhc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260119);
        return -1;
      case 1: 
        localfhc.UHj = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(260119);
        return 0;
      case 2: 
        localfhc.UHk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(260119);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          SnsObject localSnsObject = new SnsObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localSnsObject.parseFrom((byte[])localObject);
          }
          localfhc.UHl = localSnsObject;
          paramInt += 1;
        }
        AppMethodBeat.o(260119);
        return 0;
      }
      localfhc.RPH.add(Long.valueOf(((g.a.a.a.a)localObject).abFh.AN()));
      AppMethodBeat.o(260119);
      return 0;
    }
    AppMethodBeat.o(260119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhc
 * JD-Core Version:    0.7.0.1
 */