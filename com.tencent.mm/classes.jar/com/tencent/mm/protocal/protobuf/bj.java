package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bj
  extends com.tencent.mm.bx.a
{
  public String CvO;
  public String CvP;
  public String CvQ;
  public String CvR;
  public String CvS;
  public String CvT;
  public dwx CvU;
  public String CvV;
  public String fVC;
  public String sao;
  public String scR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVC != null) {
        paramVarArgs.d(1, this.fVC);
      }
      if (this.CvO != null) {
        paramVarArgs.d(2, this.CvO);
      }
      if (this.CvP != null) {
        paramVarArgs.d(3, this.CvP);
      }
      if (this.sao != null) {
        paramVarArgs.d(4, this.sao);
      }
      if (this.scR != null) {
        paramVarArgs.d(5, this.scR);
      }
      if (this.CvQ != null) {
        paramVarArgs.d(6, this.CvQ);
      }
      if (this.CvR != null) {
        paramVarArgs.d(7, this.CvR);
      }
      if (this.CvS != null) {
        paramVarArgs.d(8, this.CvS);
      }
      if (this.CvT != null) {
        paramVarArgs.d(9, this.CvT);
      }
      if (this.CvU != null)
      {
        paramVarArgs.kX(10, this.CvU.computeSize());
        this.CvU.writeFields(paramVarArgs);
      }
      if (this.CvV != null) {
        paramVarArgs.d(11, this.CvV);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVC == null) {
        break label922;
      }
    }
    label922:
    for (int i = f.a.a.b.b.a.e(1, this.fVC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CvO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CvO);
      }
      i = paramInt;
      if (this.CvP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CvP);
      }
      paramInt = i;
      if (this.sao != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sao);
      }
      i = paramInt;
      if (this.scR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.scR);
      }
      paramInt = i;
      if (this.CvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CvQ);
      }
      i = paramInt;
      if (this.CvR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CvR);
      }
      paramInt = i;
      if (this.CvS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CvS);
      }
      i = paramInt;
      if (this.CvT != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CvT);
      }
      paramInt = i;
      if (this.CvU != null) {
        paramInt = i + f.a.a.a.kW(10, this.CvU.computeSize());
      }
      i = paramInt;
      if (this.CvV != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CvV);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbj.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbj.CvO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbj.CvP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbj.sao = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbj.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbj.CvQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbj.CvR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbj.CvS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbj.CvT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbj.CvU = ((dwx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbj.CvV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */