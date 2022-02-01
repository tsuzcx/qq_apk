package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends cpx
{
  public String DKB;
  public int DKD;
  public long DKE;
  public LinkedList<String> DKF;
  public bb DKG;
  public long DKH;
  public String DKI;
  public String DKJ;
  public String DKK;
  public int scene;
  public String title;
  
  public f()
  {
    AppMethodBeat.i(91315);
    this.DKF = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DKD);
      paramVarArgs.aO(3, this.DKE);
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      paramVarArgs.e(5, 1, this.DKF);
      paramVarArgs.aR(6, this.scene);
      if (this.DKB != null) {
        paramVarArgs.d(7, this.DKB);
      }
      if (this.DKG != null)
      {
        paramVarArgs.ln(8, this.DKG.computeSize());
        this.DKG.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.DKH);
      if (this.DKI != null) {
        paramVarArgs.d(10, this.DKI);
      }
      if (this.DKJ != null) {
        paramVarArgs.d(11, this.DKJ);
      }
      if (this.DKK != null) {
        paramVarArgs.d(12, this.DKK);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DKD) + f.a.a.b.b.a.p(3, this.DKE);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.DKF) + f.a.a.b.b.a.bx(6, this.scene);
      paramInt = i;
      if (this.DKB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DKB);
      }
      i = paramInt;
      if (this.DKG != null) {
        i = paramInt + f.a.a.a.lm(8, this.DKG.computeSize());
      }
      i += f.a.a.b.b.a.p(9, this.DKH);
      paramInt = i;
      if (this.DKI != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DKI);
      }
      i = paramInt;
      if (this.DKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DKJ);
      }
      paramInt = i;
      if (this.DKK != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DKK);
      }
      AppMethodBeat.o(91316);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DKF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
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
            localf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localf.DKD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localf.DKE = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localf.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localf.DKF.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localf.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localf.DKB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.DKG = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localf.DKH = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localf.DKI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localf.DKJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localf.DKK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */