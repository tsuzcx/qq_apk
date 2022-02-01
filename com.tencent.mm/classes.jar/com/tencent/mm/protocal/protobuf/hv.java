package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hv
  extends cpx
{
  public int DVc;
  public LinkedList<za> DVd;
  public String DVe;
  public String DVf;
  public String DVg;
  public int Scene;
  public long ndf;
  
  public hv()
  {
    AppMethodBeat.i(32133);
    this.DVd = new LinkedList();
    AppMethodBeat.o(32133);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DVc);
      paramVarArgs.e(3, 8, this.DVd);
      if (this.DVe != null) {
        paramVarArgs.d(4, this.DVe);
      }
      if (this.DVf != null) {
        paramVarArgs.d(5, this.DVf);
      }
      paramVarArgs.aR(6, this.Scene);
      paramVarArgs.aO(7, this.ndf);
      if (this.DVg != null) {
        paramVarArgs.d(8, this.DVg);
      }
      AppMethodBeat.o(32134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DVc) + f.a.a.a.c(3, 8, this.DVd);
      paramInt = i;
      if (this.DVe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DVe);
      }
      i = paramInt;
      if (this.DVf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DVf);
      }
      i = i + f.a.a.b.b.a.bx(6, this.Scene) + f.a.a.b.b.a.p(7, this.ndf);
      paramInt = i;
      if (this.DVg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DVg);
      }
      AppMethodBeat.o(32134);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DVd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hv localhv = (hv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32134);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 2: 
          localhv.DVc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32134);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new za();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((za)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhv.DVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 4: 
          localhv.DVe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 5: 
          localhv.DVf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 6: 
          localhv.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32134);
          return 0;
        case 7: 
          localhv.ndf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32134);
          return 0;
        }
        localhv.DVg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32134);
        return 0;
      }
      AppMethodBeat.o(32134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hv
 * JD-Core Version:    0.7.0.1
 */