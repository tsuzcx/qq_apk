package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqj
  extends cvc
{
  public alk Glv;
  public float Goq;
  public float Gor;
  public int Gos;
  public FinderObjectDesc Got;
  public long Gou;
  public LinkedList<String> Gov;
  public String clientId;
  public float dAp;
  public float dyz;
  public int originalFlag;
  public String refObjectNonceId;
  public String username;
  
  public aqj()
  {
    AppMethodBeat.i(169036);
    this.Gov = new LinkedList();
    AppMethodBeat.o(169036);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169037);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.Got != null)
      {
        paramVarArgs.lC(3, this.Got.computeSize());
        this.Got.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.d(4, this.clientId);
      }
      paramVarArgs.aY(5, this.Gou);
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(7, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      paramVarArgs.z(8, this.dAp);
      paramVarArgs.z(9, this.dyz);
      paramVarArgs.z(10, this.Goq);
      paramVarArgs.z(11, this.Gor);
      paramVarArgs.aS(12, this.Gos);
      paramVarArgs.e(13, 1, this.Gov);
      paramVarArgs.aS(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1190;
      }
    }
    label1190:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.Got != null) {
        i = paramInt + f.a.a.a.lB(3, this.Got.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.Gou);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.Glv != null) {
        i = paramInt + f.a.a.a.lB(7, this.Glv.computeSize());
      }
      paramInt = f.a.a.b.b.a.alU(8);
      int j = f.a.a.b.b.a.alU(9);
      int k = f.a.a.b.b.a.alU(10);
      int m = f.a.a.b.b.a.alU(11);
      int n = f.a.a.b.b.a.bz(12, this.Gos);
      int i1 = f.a.a.a.c(13, 1, this.Gov);
      int i2 = f.a.a.b.b.a.bz(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gov.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqj localaqj = (aqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169037);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localaqj.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqj.Got = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localaqj.clientId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localaqj.Gou = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localaqj.refObjectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqj.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localaqj.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localaqj.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localaqj.Goq = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localaqj.Gor = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localaqj.Gos = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localaqj.Gov.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(169037);
          return 0;
        }
        localaqj.originalFlag = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqj
 * JD-Core Version:    0.7.0.1
 */