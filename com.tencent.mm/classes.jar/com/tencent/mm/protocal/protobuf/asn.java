package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class asn
  extends cvc
{
  public alk Glv;
  public String Gmz;
  public int GqB;
  public String firstPageMD5;
  public b lastBuffer;
  public String username;
  public long zhi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169070);
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
      paramVarArgs.aY(3, this.zhi);
      if (this.firstPageMD5 != null) {
        paramVarArgs.d(4, this.firstPageMD5);
      }
      if (this.Gmz != null) {
        paramVarArgs.d(5, this.Gmz);
      }
      paramVarArgs.aS(6, this.GqB);
      if (this.Glv != null)
      {
        paramVarArgs.lC(7, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      AppMethodBeat.o(169070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.zhi);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.Gmz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gmz);
      }
      i += f.a.a.b.b.a.bz(6, this.GqB);
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(7, this.Glv.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.lastBuffer);
      }
      AppMethodBeat.o(169070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asn localasn = (asn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169070);
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
            localasn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 2: 
          localasn.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 3: 
          localasn.zhi = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169070);
          return 0;
        case 4: 
          localasn.firstPageMD5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 5: 
          localasn.Gmz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 6: 
          localasn.GqB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169070);
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
            localasn.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        }
        localasn.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(169070);
        return 0;
      }
      AppMethodBeat.o(169070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asn
 * JD-Core Version:    0.7.0.1
 */