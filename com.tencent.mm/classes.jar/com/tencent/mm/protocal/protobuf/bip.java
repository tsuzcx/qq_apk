package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bip
  extends cvp
{
  public LinkedList<bnu> GDk;
  public String GDl;
  public int GDm;
  public LinkedList<String> GDn;
  public int GDo;
  public long GDp;
  public int dlw;
  public String paA;
  public String vnL;
  
  public bip()
  {
    AppMethodBeat.i(91512);
    this.dlw = 0;
    this.paA = "ok";
    this.GDk = new LinkedList();
    this.GDn = new LinkedList();
    AppMethodBeat.o(91512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91513);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.e(4, 8, this.GDk);
      if (this.GDl != null) {
        paramVarArgs.d(5, this.GDl);
      }
      paramVarArgs.aS(6, this.GDm);
      if (this.vnL != null) {
        paramVarArgs.d(7, this.vnL);
      }
      paramVarArgs.e(8, 1, this.GDn);
      paramVarArgs.aS(9, this.GDo);
      paramVarArgs.aY(10, this.GDp);
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GDk);
      paramInt = i;
      if (this.GDl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GDl);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GDm);
      paramInt = i;
      if (this.vnL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vnL);
      }
      i = f.a.a.a.c(8, 1, this.GDn);
      int j = f.a.a.b.b.a.bz(9, this.GDo);
      int k = f.a.a.b.b.a.p(10, this.GDp);
      AppMethodBeat.o(91513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GDk.clear();
        this.GDn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bip localbip = (bip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
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
            localbip.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localbip.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localbip.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbip.GDk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localbip.GDl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localbip.GDm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localbip.vnL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localbip.GDn.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localbip.GDo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91513);
          return 0;
        }
        localbip.GDp = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bip
 * JD-Core Version:    0.7.0.1
 */