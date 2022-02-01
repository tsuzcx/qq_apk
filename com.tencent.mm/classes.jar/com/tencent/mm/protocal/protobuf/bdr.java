package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdr
  extends cld
{
  public String CDV;
  public String CNe;
  public dtz CWj;
  public String DBa;
  public int DBb;
  public String DBc;
  public LinkedList<bss> DBd;
  public int DBe;
  public String DBf;
  public String DBg;
  public int DBh;
  public String DBi;
  public int DBj;
  public int DBk;
  public bss DBl;
  public String doh;
  public int msf;
  
  public bdr()
  {
    AppMethodBeat.i(123591);
    this.DBd = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CWj != null)
      {
        paramVarArgs.kX(2, this.CWj.computeSize());
        this.CWj.writeFields(paramVarArgs);
      }
      if (this.DBa != null) {
        paramVarArgs.d(3, this.DBa);
      }
      paramVarArgs.aR(4, this.DBb);
      paramVarArgs.aR(5, this.msf);
      if (this.DBc != null) {
        paramVarArgs.d(6, this.DBc);
      }
      paramVarArgs.e(7, 8, this.DBd);
      paramVarArgs.aR(8, this.DBe);
      if (this.DBf != null) {
        paramVarArgs.d(9, this.DBf);
      }
      if (this.DBg != null) {
        paramVarArgs.d(10, this.DBg);
      }
      paramVarArgs.aR(11, this.DBh);
      if (this.doh != null) {
        paramVarArgs.d(12, this.doh);
      }
      if (this.CDV != null) {
        paramVarArgs.d(13, this.CDV);
      }
      if (this.CNe != null) {
        paramVarArgs.d(14, this.CNe);
      }
      if (this.DBi != null) {
        paramVarArgs.d(15, this.DBi);
      }
      paramVarArgs.aR(16, this.DBj);
      paramVarArgs.aR(17, this.DBk);
      if (this.DBl != null)
      {
        paramVarArgs.kX(18, this.DBl.computeSize());
        this.DBl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CWj != null) {
        paramInt = i + f.a.a.a.kW(2, this.CWj.computeSize());
      }
      i = paramInt;
      if (this.DBa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DBa);
      }
      i = i + f.a.a.b.b.a.bA(4, this.DBb) + f.a.a.b.b.a.bA(5, this.msf);
      paramInt = i;
      if (this.DBc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DBc);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.DBd) + f.a.a.b.b.a.bA(8, this.DBe);
      paramInt = i;
      if (this.DBf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DBf);
      }
      i = paramInt;
      if (this.DBg != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DBg);
      }
      i += f.a.a.b.b.a.bA(11, this.DBh);
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.doh);
      }
      i = paramInt;
      if (this.CDV != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.CDV);
      }
      paramInt = i;
      if (this.CNe != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.CNe);
      }
      i = paramInt;
      if (this.DBi != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DBi);
      }
      i = i + f.a.a.b.b.a.bA(16, this.DBj) + f.a.a.b.b.a.bA(17, this.DBk);
      paramInt = i;
      if (this.DBl != null) {
        paramInt = i + f.a.a.a.kW(18, this.DBl.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DBd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdr localbdr = (bdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdr.CWj = ((dtz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localbdr.DBa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localbdr.DBb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localbdr.msf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localbdr.DBc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdr.DBd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localbdr.DBe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localbdr.DBf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localbdr.DBg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localbdr.DBh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localbdr.doh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localbdr.CDV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localbdr.CNe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localbdr.DBi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localbdr.DBj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localbdr.DBk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bss();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdr.DBl = ((bss)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdr
 * JD-Core Version:    0.7.0.1
 */