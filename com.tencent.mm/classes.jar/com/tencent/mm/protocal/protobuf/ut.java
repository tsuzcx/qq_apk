package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ut
  extends cpx
{
  public int EoJ;
  public LinkedList<crm> EoK;
  public String EoL;
  public String EoM;
  public int Scene;
  public String fZx;
  public int sVo;
  public String tlJ;
  public String tlX;
  
  public ut()
  {
    AppMethodBeat.i(124468);
    this.EoK = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.sVo);
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      if (this.tlX != null) {
        paramVarArgs.d(4, this.tlX);
      }
      if (this.fZx != null) {
        paramVarArgs.d(5, this.fZx);
      }
      paramVarArgs.aR(6, this.EoJ);
      paramVarArgs.e(7, 8, this.EoK);
      if (this.EoL != null) {
        paramVarArgs.d(8, this.EoL);
      }
      if (this.EoM != null) {
        paramVarArgs.d(9, this.EoM);
      }
      paramVarArgs.aR(10, this.Scene);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.sVo);
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tlJ);
      }
      i = paramInt;
      if (this.tlX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tlX);
      }
      paramInt = i;
      if (this.fZx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.fZx);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.EoJ) + f.a.a.a.c(7, 8, this.EoK);
      paramInt = i;
      if (this.EoL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EoL);
      }
      i = paramInt;
      if (this.EoM != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EoM);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.Scene);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EoK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ut localut = (ut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
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
            localut.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localut.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localut.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localut.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localut.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localut.EoJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localut.EoK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localut.EoL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localut.EoM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localut.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ut
 * JD-Core Version:    0.7.0.1
 */