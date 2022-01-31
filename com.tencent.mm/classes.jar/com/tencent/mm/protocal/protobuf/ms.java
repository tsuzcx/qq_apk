package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a.c;
import e.a.a.b;
import java.util.LinkedList;

public final class ms
  extends bvk
{
  public int koj;
  public String kok;
  public c ukr;
  public long ukt;
  public long wBG;
  public LinkedList<String> wBH;
  public int wBI;
  public int wBJ;
  public String wBK;
  public String wBL;
  public String wBM;
  public boolean wBN;
  
  public ms()
  {
    AppMethodBeat.i(56727);
    this.wBH = new LinkedList();
    AppMethodBeat.o(56727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56728);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56728);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.am(4, this.ukt);
      if (this.ukr != null)
      {
        paramVarArgs.iQ(5, this.ukr.computeSize());
        this.ukr.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.wBG);
      paramVarArgs.e(7, 1, this.wBH);
      paramVarArgs.aO(8, this.wBI);
      paramVarArgs.aO(9, this.wBJ);
      if (this.wBK != null) {
        paramVarArgs.e(10, this.wBK);
      }
      if (this.wBL != null) {
        paramVarArgs.e(11, this.wBL);
      }
      if (this.wBM != null) {
        paramVarArgs.e(12, this.wBM);
      }
      paramVarArgs.aS(13, this.wBN);
      AppMethodBeat.o(56728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.p(4, this.ukt);
      paramInt = i;
      if (this.ukr != null) {
        paramInt = i + e.a.a.a.iP(5, this.ukr.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.p(6, this.wBG) + e.a.a.a.c(7, 1, this.wBH) + e.a.a.b.b.a.bl(8, this.wBI) + e.a.a.b.b.a.bl(9, this.wBJ);
      paramInt = i;
      if (this.wBK != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wBK);
      }
      i = paramInt;
      if (this.wBL != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wBL);
      }
      paramInt = i;
      if (this.wBM != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wBM);
      }
      i = e.a.a.b.b.a.eW(13);
      AppMethodBeat.o(56728);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wBH.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56728);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ms localms = (ms)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56728);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localms.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56728);
          return 0;
        case 2: 
          localms.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56728);
          return 0;
        case 3: 
          localms.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56728);
          return 0;
        case 4: 
          localms.ukt = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56728);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localms.ukr = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56728);
          return 0;
        case 6: 
          localms.wBG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56728);
          return 0;
        case 7: 
          localms.wBH.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56728);
          return 0;
        case 8: 
          localms.wBI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56728);
          return 0;
        case 9: 
          localms.wBJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56728);
          return 0;
        case 10: 
          localms.wBK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56728);
          return 0;
        case 11: 
          localms.wBL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56728);
          return 0;
        case 12: 
          localms.wBM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56728);
          return 0;
        }
        localms.wBN = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(56728);
        return 0;
      }
      AppMethodBeat.o(56728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ms
 * JD-Core Version:    0.7.0.1
 */