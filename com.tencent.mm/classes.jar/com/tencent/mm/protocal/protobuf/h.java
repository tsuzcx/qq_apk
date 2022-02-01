package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends cpx
{
  public String DKB;
  public LinkedList<j> DKF;
  public bb DKG;
  public long DKH;
  public String DKI;
  public String DKJ;
  public String DKK;
  public long DKN;
  public int scene;
  public String title;
  
  public h()
  {
    AppMethodBeat.i(91318);
    this.DKF = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aO(3, this.DKN);
      paramVarArgs.e(5, 8, this.DKF);
      paramVarArgs.aR(7, this.scene);
      if (this.DKB != null) {
        paramVarArgs.d(8, this.DKB);
      }
      if (this.DKG != null)
      {
        paramVarArgs.ln(9, this.DKG.computeSize());
        this.DKG.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.DKH);
      if (this.DKI != null) {
        paramVarArgs.d(11, this.DKI);
      }
      if (this.DKJ != null) {
        paramVarArgs.d(12, this.DKJ);
      }
      if (this.DKK != null) {
        paramVarArgs.d(13, this.DKK);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i = i + f.a.a.b.b.a.p(3, this.DKN) + f.a.a.a.c(5, 8, this.DKF) + f.a.a.b.b.a.bx(7, this.scene);
      paramInt = i;
      if (this.DKB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DKB);
      }
      i = paramInt;
      if (this.DKG != null) {
        i = paramInt + f.a.a.a.lm(9, this.DKG.computeSize());
      }
      i += f.a.a.b.b.a.p(10, this.DKH);
      paramInt = i;
      if (this.DKI != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DKI);
      }
      i = paramInt;
      if (this.DKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DKJ);
      }
      paramInt = i;
      if (this.DKK != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DKK);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localh.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localh.DKN = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.DKF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localh.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localh.DKB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.DKG = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localh.DKH = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localh.DKI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localh.DKJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localh.DKK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */