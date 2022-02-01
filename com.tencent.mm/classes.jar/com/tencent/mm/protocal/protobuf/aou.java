package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aou
  extends cvc
{
  public alk Glv;
  public int Gnp;
  public String Gnq;
  public int Gnr;
  public long commentId;
  public String objectNonceId;
  public int opType;
  public long rHI;
  public long rIZ;
  public int scene;
  public String sessionBuffer;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rIZ);
      paramVarArgs.aY(3, this.commentId);
      paramVarArgs.aS(4, this.opType);
      paramVarArgs.aY(5, this.rHI);
      paramVarArgs.aS(6, this.Gnp);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aS(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(9, this.objectNonceId);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(10, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(11, this.sessionBuffer);
      }
      if (this.Gnq != null) {
        paramVarArgs.d(12, this.Gnq);
      }
      paramVarArgs.aS(13, this.Gnr);
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.rIZ) + f.a.a.b.b.a.p(3, this.commentId) + f.a.a.b.b.a.bz(4, this.opType) + f.a.a.b.b.a.p(5, this.rHI) + f.a.a.b.b.a.bz(6, this.Gnp);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.Glv != null) {
        i = paramInt + f.a.a.a.lB(10, this.Glv.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.Gnq != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gnq);
      }
      paramInt = f.a.a.b.b.a.bz(13, this.Gnr);
      AppMethodBeat.o(169002);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aou localaou = (aou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
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
            localaou.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localaou.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localaou.commentId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localaou.opType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localaou.rHI = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localaou.Gnp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localaou.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localaou.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localaou.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaou.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localaou.sessionBuffer = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 12: 
          localaou.Gnq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169002);
          return 0;
        }
        localaou.Gnr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aou
 * JD-Core Version:    0.7.0.1
 */