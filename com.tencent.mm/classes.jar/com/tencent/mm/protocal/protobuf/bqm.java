package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqm
  extends cvc
{
  public String GKT;
  public String GKU;
  public int GKV;
  public int GKW;
  public String GKX;
  public String GKY;
  public String duW;
  public int paC;
  public String packageName;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.GKT != null) {
        paramVarArgs.d(3, this.GKT);
      }
      paramVarArgs.aS(4, this.scene);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.GKU != null) {
        paramVarArgs.d(6, this.GKU);
      }
      paramVarArgs.aS(7, this.paC);
      paramVarArgs.aS(8, this.GKV);
      paramVarArgs.aS(9, this.GKW);
      if (this.GKX != null) {
        paramVarArgs.d(10, this.GKX);
      }
      if (this.packageName != null) {
        paramVarArgs.d(11, this.packageName);
      }
      if (this.GKY != null) {
        paramVarArgs.d(12, this.GKY);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.GKT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GKT);
      }
      i += f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.GKU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GKU);
      }
      i = i + f.a.a.b.b.a.bz(7, this.paC) + f.a.a.b.b.a.bz(8, this.GKV) + f.a.a.b.b.a.bz(9, this.GKW);
      paramInt = i;
      if (this.GKX != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GKX);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.packageName);
      }
      paramInt = i;
      if (this.GKY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GKY);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqm localbqm = (bqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
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
            localbqm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localbqm.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localbqm.GKT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localbqm.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localbqm.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localbqm.GKU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localbqm.paC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localbqm.GKV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localbqm.GKW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localbqm.GKX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localbqm.packageName = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localbqm.GKY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqm
 * JD-Core Version:    0.7.0.1
 */