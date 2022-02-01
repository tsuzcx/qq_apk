package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czk
  extends cvp
{
  public int CreateTime;
  public String FOH;
  public int FOM;
  public String Fwt;
  public String iht;
  public int nEf;
  public String uki;
  public String ukj;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.ukj != null) {
        paramVarArgs.d(3, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(4, this.uki);
      }
      paramVarArgs.aS(5, this.xbr);
      if (this.Fwt != null) {
        paramVarArgs.d(6, this.Fwt);
      }
      paramVarArgs.aS(7, this.CreateTime);
      paramVarArgs.aS(8, this.nEf);
      paramVarArgs.aY(9, this.xbt);
      if (this.FOH != null) {
        paramVarArgs.d(10, this.FOH);
      }
      paramVarArgs.aS(12, this.FOM);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label911;
      }
    }
    label911:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.ukj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ukj);
      }
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uki);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xbr);
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fwt);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.CreateTime) + f.a.a.b.b.a.bz(8, this.nEf) + f.a.a.b.b.a.p(9, this.xbt);
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FOH);
      }
      i = f.a.a.b.b.a.bz(12, this.FOM);
      AppMethodBeat.o(32427);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czk localczk = (czk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localczk.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localczk.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localczk.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localczk.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localczk.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localczk.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localczk.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localczk.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localczk.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localczk.FOM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czk
 * JD-Core Version:    0.7.0.1
 */