package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzy
  extends com.tencent.mm.bw.a
{
  public int ERF;
  public caa ERG;
  public int FoO;
  public bzz FoP;
  public int FoQ;
  public int FoR;
  public int FoS;
  public int FoT;
  public String app_id;
  public String ioe;
  public int uGY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ioe != null) {
        paramVarArgs.d(1, this.ioe);
      }
      paramVarArgs.aR(2, this.FoO);
      if (this.FoP != null)
      {
        paramVarArgs.ln(3, this.FoP.computeSize());
        this.FoP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.ERF);
      if (this.ERG != null)
      {
        paramVarArgs.ln(5, this.ERG.computeSize());
        this.ERG.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.FoQ);
      paramVarArgs.aR(7, this.FoR);
      paramVarArgs.aR(8, this.uGY);
      paramVarArgs.aR(9, this.FoS);
      if (this.app_id != null) {
        paramVarArgs.d(10, this.app_id);
      }
      paramVarArgs.aR(11, this.FoT);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ioe == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = f.a.a.b.b.a.e(1, this.ioe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FoO);
      paramInt = i;
      if (this.FoP != null) {
        paramInt = i + f.a.a.a.lm(3, this.FoP.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.ERF);
      paramInt = i;
      if (this.ERG != null) {
        paramInt = i + f.a.a.a.lm(5, this.ERG.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FoQ) + f.a.a.b.b.a.bx(7, this.FoR) + f.a.a.b.b.a.bx(8, this.uGY) + f.a.a.b.b.a.bx(9, this.FoS);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.app_id);
      }
      i = f.a.a.b.b.a.bx(11, this.FoT);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzy localbzy = (bzy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localbzy.ioe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localbzy.FoO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzy.FoP = ((bzz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localbzy.ERF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzy.ERG = ((caa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localbzy.FoQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localbzy.FoR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localbzy.uGY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localbzy.FoS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localbzy.app_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localbzy.FoT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzy
 * JD-Core Version:    0.7.0.1
 */