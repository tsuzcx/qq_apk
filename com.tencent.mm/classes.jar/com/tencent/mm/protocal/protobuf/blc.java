package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blc
  extends cvp
{
  public String Desc;
  public int GEY;
  public LinkedList<eal> GEZ;
  public String GFm;
  public String GFn;
  public String GFo;
  public String GFp;
  public String GFq;
  public String GFr;
  public ear GFs;
  public String GFt;
  public String GFu;
  public String GFv;
  public String GFw;
  public String GFx;
  public String Title;
  public String uOt;
  
  public blc()
  {
    AppMethodBeat.i(32308);
    this.GEZ = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GFm != null) {
        paramVarArgs.d(2, this.GFm);
      }
      if (this.uOt != null) {
        paramVarArgs.d(3, this.uOt);
      }
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(5, this.Desc);
      }
      if (this.GFn != null) {
        paramVarArgs.d(6, this.GFn);
      }
      if (this.GFo != null) {
        paramVarArgs.d(7, this.GFo);
      }
      if (this.GFp != null) {
        paramVarArgs.d(8, this.GFp);
      }
      if (this.GFq != null) {
        paramVarArgs.d(9, this.GFq);
      }
      if (this.GFr != null) {
        paramVarArgs.d(10, this.GFr);
      }
      if (this.GFs != null)
      {
        paramVarArgs.lC(11, this.GFs.computeSize());
        this.GFs.writeFields(paramVarArgs);
      }
      if (this.GFt != null) {
        paramVarArgs.d(12, this.GFt);
      }
      if (this.GFu != null) {
        paramVarArgs.d(13, this.GFu);
      }
      if (this.GFv != null) {
        paramVarArgs.d(14, this.GFv);
      }
      if (this.GFw != null) {
        paramVarArgs.d(15, this.GFw);
      }
      if (this.GFx != null) {
        paramVarArgs.d(16, this.GFx);
      }
      paramVarArgs.aS(17, this.GEY);
      paramVarArgs.e(18, 8, this.GEZ);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GFm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GFm);
      }
      i = paramInt;
      if (this.uOt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uOt);
      }
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Desc);
      }
      paramInt = i;
      if (this.GFn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GFn);
      }
      i = paramInt;
      if (this.GFo != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GFo);
      }
      paramInt = i;
      if (this.GFp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GFp);
      }
      i = paramInt;
      if (this.GFq != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GFq);
      }
      paramInt = i;
      if (this.GFr != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GFr);
      }
      i = paramInt;
      if (this.GFs != null) {
        i = paramInt + f.a.a.a.lB(11, this.GFs.computeSize());
      }
      paramInt = i;
      if (this.GFt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GFt);
      }
      i = paramInt;
      if (this.GFu != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GFu);
      }
      paramInt = i;
      if (this.GFv != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GFv);
      }
      i = paramInt;
      if (this.GFw != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GFw);
      }
      paramInt = i;
      if (this.GFx != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GFx);
      }
      i = f.a.a.b.b.a.bz(17, this.GEY);
      int j = f.a.a.a.c(18, 8, this.GEZ);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GEZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blc localblc = (blc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localblc.GFm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localblc.uOt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localblc.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localblc.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localblc.GFn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localblc.GFo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localblc.GFp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localblc.GFq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localblc.GFr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ear();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ear)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblc.GFs = ((ear)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localblc.GFt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localblc.GFu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localblc.GFv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localblc.GFw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localblc.GFx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localblc.GEY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eal();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblc.GEZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blc
 * JD-Core Version:    0.7.0.1
 */