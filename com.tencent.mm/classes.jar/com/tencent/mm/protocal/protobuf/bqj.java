package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bqj
  extends cvc
{
  public String GKI;
  public String GKK;
  public String GKL;
  public b GKM;
  public int GKN;
  public String GKO;
  public String cUM;
  public String gsT;
  public String scope;
  public String signature;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.gsT != null) {
        paramVarArgs.d(3, this.gsT);
      }
      if (this.GKI != null) {
        paramVarArgs.d(4, this.GKI);
      }
      if (this.cUM != null) {
        paramVarArgs.d(5, this.cUM);
      }
      if (this.GKK != null) {
        paramVarArgs.d(6, this.GKK);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.GKL != null) {
        paramVarArgs.d(8, this.GKL);
      }
      if (this.GKM != null) {
        paramVarArgs.c(9, this.GKM);
      }
      paramVarArgs.aS(10, this.GKN);
      if (this.scope != null) {
        paramVarArgs.d(11, this.scope);
      }
      if (this.GKO != null) {
        paramVarArgs.d(12, this.GKO);
      }
      AppMethodBeat.o(82433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.gsT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsT);
      }
      paramInt = i;
      if (this.GKI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKI);
      }
      i = paramInt;
      if (this.cUM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cUM);
      }
      paramInt = i;
      if (this.GKK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKK);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.signature);
      }
      paramInt = i;
      if (this.GKL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GKL);
      }
      i = paramInt;
      if (this.GKM != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.GKM);
      }
      i += f.a.a.b.b.a.bz(10, this.GKN);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.scope);
      }
      i = paramInt;
      if (this.GKO != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GKO);
      }
      AppMethodBeat.o(82433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqj localbqj = (bqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82433);
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
            localbqj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82433);
          return 0;
        case 2: 
          localbqj.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 3: 
          localbqj.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 4: 
          localbqj.GKI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 5: 
          localbqj.cUM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 6: 
          localbqj.GKK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 7: 
          localbqj.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 8: 
          localbqj.GKL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 9: 
          localbqj.GKM = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(82433);
          return 0;
        case 10: 
          localbqj.GKN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82433);
          return 0;
        case 11: 
          localbqj.scope = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82433);
          return 0;
        }
        localbqj.GKO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82433);
        return 0;
      }
      AppMethodBeat.o(82433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqj
 * JD-Core Version:    0.7.0.1
 */