package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bap
  extends cld
{
  public LinkedList<bfu> Dyr;
  public String Dys;
  public int Dyt;
  public LinkedList<String> Dyu;
  public int Dyv;
  public long Dyw;
  public int dcG;
  public String nTK;
  public String tcQ;
  
  public bap()
  {
    AppMethodBeat.i(91512);
    this.dcG = 0;
    this.nTK = "ok";
    this.Dyr = new LinkedList();
    this.Dyu = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.e(4, 8, this.Dyr);
      if (this.Dys != null) {
        paramVarArgs.d(5, this.Dys);
      }
      paramVarArgs.aR(6, this.Dyt);
      if (this.tcQ != null) {
        paramVarArgs.d(7, this.tcQ);
      }
      paramVarArgs.e(8, 1, this.Dyu);
      paramVarArgs.aR(9, this.Dyv);
      paramVarArgs.aG(10, this.Dyw);
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Dyr);
      paramInt = i;
      if (this.Dys != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dys);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.Dyt);
      paramInt = i;
      if (this.tcQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tcQ);
      }
      i = f.a.a.a.c(8, 1, this.Dyu);
      int j = f.a.a.b.b.a.bA(9, this.Dyv);
      int k = f.a.a.b.b.a.q(10, this.Dyw);
      AppMethodBeat.o(91513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dyr.clear();
        this.Dyu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        bap localbap = (bap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
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
            localbap.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localbap.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localbap.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbap.Dyr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localbap.Dys = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localbap.Dyt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localbap.tcQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localbap.Dyu.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localbap.Dyv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91513);
          return 0;
        }
        localbap.Dyw = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bap
 * JD-Core Version:    0.7.0.1
 */