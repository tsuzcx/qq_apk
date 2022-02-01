package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ang
  extends cvc
{
  public alk Glv;
  public long Gmp;
  public int Gmq;
  public String Gmr;
  public int Gms;
  public int direction;
  public b lastBuffer;
  public b likeBuffer;
  public String objectNonceId;
  public long rID;
  public long rIH;
  public int rIK;
  public long rIZ;
  public String rTn;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rIZ);
      paramVarArgs.aY(3, this.Gmp);
      paramVarArgs.aS(4, this.Gmq);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aY(6, this.rID);
      if (this.rTn != null) {
        paramVarArgs.d(7, this.rTn);
      }
      paramVarArgs.aY(8, this.rIH);
      paramVarArgs.aS(9, this.scene);
      paramVarArgs.aS(10, this.direction);
      if (this.Gmr != null) {
        paramVarArgs.d(11, this.Gmr);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(12, this.objectNonceId);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(13, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.Gms);
      paramVarArgs.aS(15, this.rIK);
      if (this.likeBuffer != null) {
        paramVarArgs.c(16, this.likeBuffer);
      }
      AppMethodBeat.o(168973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1174;
      }
    }
    label1174:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.rIZ) + f.a.a.b.b.a.p(3, this.Gmp) + f.a.a.b.b.a.bz(4, this.Gmq);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.rID);
      paramInt = i;
      if (this.rTn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.rTn);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.rIH) + f.a.a.b.b.a.bz(9, this.scene) + f.a.a.b.b.a.bz(10, this.direction);
      paramInt = i;
      if (this.Gmr != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gmr);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.objectNonceId);
      }
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(13, this.Glv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.Gms) + f.a.a.b.b.a.bz(15, this.rIK);
      paramInt = i;
      if (this.likeBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.likeBuffer);
      }
      AppMethodBeat.o(168973);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ang localang = (ang)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168973);
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
            localang.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 2: 
          localang.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 3: 
          localang.Gmp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 4: 
          localang.Gmq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 5: 
          localang.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168973);
          return 0;
        case 6: 
          localang.rID = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 7: 
          localang.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 8: 
          localang.rIH = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168973);
          return 0;
        case 9: 
          localang.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 10: 
          localang.direction = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 11: 
          localang.Gmr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 12: 
          localang.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168973);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localang.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168973);
          return 0;
        case 14: 
          localang.Gms = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168973);
          return 0;
        case 15: 
          localang.rIK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168973);
          return 0;
        }
        localang.likeBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(168973);
        return 0;
      }
      AppMethodBeat.o(168973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ang
 * JD-Core Version:    0.7.0.1
 */