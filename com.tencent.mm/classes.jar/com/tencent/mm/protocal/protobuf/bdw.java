package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdw
  extends cld
{
  public dtz CWj;
  public String DBA;
  public String DBB;
  public String DBC;
  public String DBD;
  public int DBj;
  public LinkedList<dvh> DBw;
  public dvh DBx;
  public String DBy;
  public int DBz;
  
  public bdw()
  {
    AppMethodBeat.i(123594);
    this.DBw = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
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
      paramVarArgs.e(3, 8, this.DBw);
      if (this.DBx != null)
      {
        paramVarArgs.kX(4, this.DBx.computeSize());
        this.DBx.writeFields(paramVarArgs);
      }
      if (this.DBy != null) {
        paramVarArgs.d(5, this.DBy);
      }
      paramVarArgs.aR(6, this.DBz);
      if (this.DBA != null) {
        paramVarArgs.d(7, this.DBA);
      }
      if (this.DBB != null) {
        paramVarArgs.d(8, this.DBB);
      }
      if (this.DBC != null) {
        paramVarArgs.d(9, this.DBC);
      }
      if (this.DBD != null) {
        paramVarArgs.d(10, this.DBD);
      }
      paramVarArgs.aR(11, this.DBj);
      AppMethodBeat.o(123595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CWj != null) {
        i = paramInt + f.a.a.a.kW(2, this.CWj.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.DBw);
      paramInt = i;
      if (this.DBx != null) {
        paramInt = i + f.a.a.a.kW(4, this.DBx.computeSize());
      }
      i = paramInt;
      if (this.DBy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DBy);
      }
      i += f.a.a.b.b.a.bA(6, this.DBz);
      paramInt = i;
      if (this.DBA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DBA);
      }
      i = paramInt;
      if (this.DBB != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DBB);
      }
      paramInt = i;
      if (this.DBC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DBC);
      }
      i = paramInt;
      if (this.DBD != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DBD);
      }
      paramInt = f.a.a.b.b.a.bA(11, this.DBj);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DBw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdw localbdw = (bdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localbdw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
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
            localbdw.CWj = ((dtz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdw.DBw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdw.DBx = ((dvh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localbdw.DBy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localbdw.DBz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localbdw.DBA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localbdw.DBB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localbdw.DBC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localbdw.DBD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localbdw.DBj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdw
 * JD-Core Version:    0.7.0.1
 */