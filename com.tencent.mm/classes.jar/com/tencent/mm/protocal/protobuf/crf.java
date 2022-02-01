package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crf
  extends cvc
{
  public int GNa;
  public String gsM;
  public String gsN;
  public String gsO;
  public String gsP;
  public String gsQ;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gsM != null) {
        paramVarArgs.d(2, this.gsM);
      }
      if (this.gsN != null) {
        paramVarArgs.d(3, this.gsN);
      }
      if (this.gsO != null) {
        paramVarArgs.d(4, this.gsO);
      }
      if (this.gsP != null) {
        paramVarArgs.d(5, this.gsP);
      }
      if (this.gsQ != null) {
        paramVarArgs.d(6, this.gsQ);
      }
      paramVarArgs.aS(7, this.GNa);
      if (this.yhw != null) {
        paramVarArgs.d(8, this.yhw);
      }
      AppMethodBeat.o(152666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gsM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gsM);
      }
      i = paramInt;
      if (this.gsN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsN);
      }
      paramInt = i;
      if (this.gsO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gsO);
      }
      i = paramInt;
      if (this.gsP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gsP);
      }
      paramInt = i;
      if (this.gsQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gsQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GNa);
      paramInt = i;
      if (this.yhw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.yhw);
      }
      AppMethodBeat.o(152666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crf localcrf = (crf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152666);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152666);
          return 0;
        case 2: 
          localcrf.gsM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 3: 
          localcrf.gsN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 4: 
          localcrf.gsO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 5: 
          localcrf.gsP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 6: 
          localcrf.gsQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 7: 
          localcrf.GNa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152666);
          return 0;
        }
        localcrf.yhw = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152666);
        return 0;
      }
      AppMethodBeat.o(152666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crf
 * JD-Core Version:    0.7.0.1
 */