package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwx
  extends dyl
{
  public int CPw;
  public int RNt;
  public String SYn;
  public cqg Srh;
  public eae TgD;
  public int TgE;
  public int TgF;
  public LinkedList<dlb> TgG;
  public int TgH;
  
  public bwx()
  {
    AppMethodBeat.i(32249);
    this.TgG = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Srh == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RNt);
      paramVarArgs.aY(3, this.CPw);
      if (this.TgD != null)
      {
        paramVarArgs.oE(4, this.TgD.computeSize());
        this.TgD.writeFields(paramVarArgs);
      }
      if (this.Srh != null)
      {
        paramVarArgs.oE(5, this.Srh.computeSize());
        this.Srh.writeFields(paramVarArgs);
      }
      if (this.SYn != null) {
        paramVarArgs.f(6, this.SYn);
      }
      paramVarArgs.aY(7, this.TgE);
      paramVarArgs.aY(8, this.TgF);
      paramVarArgs.e(11, 8, this.TgG);
      paramVarArgs.aY(12, this.TgH);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1038;
      }
    }
    label1038:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNt) + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.TgD != null) {
        paramInt = i + g.a.a.a.oD(4, this.TgD.computeSize());
      }
      i = paramInt;
      if (this.Srh != null) {
        i = paramInt + g.a.a.a.oD(5, this.Srh.computeSize());
      }
      paramInt = i;
      if (this.SYn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SYn);
      }
      i = g.a.a.b.b.a.bM(7, this.TgE);
      int j = g.a.a.b.b.a.bM(8, this.TgF);
      int k = g.a.a.a.c(11, 8, this.TgG);
      int m = g.a.a.b.b.a.bM(12, this.TgH);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TgG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Srh == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwx localbwx = (bwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbwx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localbwx.RNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localbwx.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32250);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbwx.TgD = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqg)localObject2).parseFrom((byte[])localObject1);
            }
            localbwx.Srh = ((cqg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localbwx.SYn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localbwx.TgE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localbwx.TgF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlb)localObject2).parseFrom((byte[])localObject1);
            }
            localbwx.TgG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localbwx.TgH = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwx
 * JD-Core Version:    0.7.0.1
 */