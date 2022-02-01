package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bl
  extends com.tencent.mm.bw.a
{
  public String FLO;
  public String FLP;
  public String FLQ;
  public String FLR;
  public String FLS;
  public String FLT;
  public ekl FLU;
  public String FLV;
  public String gvv;
  public String urv;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv != null) {
        paramVarArgs.d(1, this.gvv);
      }
      if (this.FLO != null) {
        paramVarArgs.d(2, this.FLO);
      }
      if (this.FLP != null) {
        paramVarArgs.d(3, this.FLP);
      }
      if (this.urv != null) {
        paramVarArgs.d(4, this.urv);
      }
      if (this.uuo != null) {
        paramVarArgs.d(5, this.uuo);
      }
      if (this.FLQ != null) {
        paramVarArgs.d(6, this.FLQ);
      }
      if (this.FLR != null) {
        paramVarArgs.d(7, this.FLR);
      }
      if (this.FLS != null) {
        paramVarArgs.d(8, this.FLS);
      }
      if (this.FLT != null) {
        paramVarArgs.d(9, this.FLT);
      }
      if (this.FLU != null)
      {
        paramVarArgs.lJ(10, this.FLU.computeSize());
        this.FLU.writeFields(paramVarArgs);
      }
      if (this.FLV != null) {
        paramVarArgs.d(11, this.FLV);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvv == null) {
        break label922;
      }
    }
    label922:
    for (int i = f.a.a.b.b.a.e(1, this.gvv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FLO);
      }
      i = paramInt;
      if (this.FLP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLP);
      }
      paramInt = i;
      if (this.urv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.urv);
      }
      i = paramInt;
      if (this.uuo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uuo);
      }
      paramInt = i;
      if (this.FLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FLQ);
      }
      i = paramInt;
      if (this.FLR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FLR);
      }
      paramInt = i;
      if (this.FLS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FLS);
      }
      i = paramInt;
      if (this.FLT != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FLT);
      }
      paramInt = i;
      if (this.FLU != null) {
        paramInt = i + f.a.a.a.lI(10, this.FLU.computeSize());
      }
      i = paramInt;
      if (this.FLV != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FLV);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbl.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbl.FLO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbl.FLP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbl.urv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbl.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbl.FLQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbl.FLR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbl.FLS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbl.FLT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ekl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbl.FLU = ((ekl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbl.FLV = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */