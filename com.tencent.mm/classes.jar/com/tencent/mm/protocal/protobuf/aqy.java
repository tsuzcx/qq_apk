package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqy
  extends cld
{
  public pw CGH;
  public pw CGI;
  public pw CGJ;
  public SKBuiltinBuffer_t CGK;
  public SKBuiltinBuffer_t CGL;
  public pw CGM;
  public int CGN;
  public pv CGO;
  public pv CGP;
  public int DrF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.CGH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DnsInfo");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CGH != null)
      {
        paramVarArgs.kX(2, this.CGH.computeSize());
        this.CGH.writeFields(paramVarArgs);
      }
      if (this.CGI != null)
      {
        paramVarArgs.kX(3, this.CGI.computeSize());
        this.CGI.writeFields(paramVarArgs);
      }
      if (this.CGJ != null)
      {
        paramVarArgs.kX(4, this.CGJ.computeSize());
        this.CGJ.writeFields(paramVarArgs);
      }
      if (this.CGK != null)
      {
        paramVarArgs.kX(5, this.CGK.computeSize());
        this.CGK.writeFields(paramVarArgs);
      }
      if (this.CGL != null)
      {
        paramVarArgs.kX(6, this.CGL.computeSize());
        this.CGL.writeFields(paramVarArgs);
      }
      if (this.CGM != null)
      {
        paramVarArgs.kX(7, this.CGM.computeSize());
        this.CGM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.CGN);
      if (this.CGO != null)
      {
        paramVarArgs.kX(9, this.CGO.computeSize());
        this.CGO.writeFields(paramVarArgs);
      }
      if (this.CGP != null)
      {
        paramVarArgs.kX(10, this.CGP.computeSize());
        this.CGP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.DrF);
      AppMethodBeat.o(152567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1738;
      }
    }
    label1738:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGH != null) {
        paramInt = i + f.a.a.a.kW(2, this.CGH.computeSize());
      }
      i = paramInt;
      if (this.CGI != null) {
        i = paramInt + f.a.a.a.kW(3, this.CGI.computeSize());
      }
      paramInt = i;
      if (this.CGJ != null) {
        paramInt = i + f.a.a.a.kW(4, this.CGJ.computeSize());
      }
      i = paramInt;
      if (this.CGK != null) {
        i = paramInt + f.a.a.a.kW(5, this.CGK.computeSize());
      }
      paramInt = i;
      if (this.CGL != null) {
        paramInt = i + f.a.a.a.kW(6, this.CGL.computeSize());
      }
      i = paramInt;
      if (this.CGM != null) {
        i = paramInt + f.a.a.a.kW(7, this.CGM.computeSize());
      }
      i += f.a.a.b.b.a.bA(8, this.CGN);
      paramInt = i;
      if (this.CGO != null) {
        paramInt = i + f.a.a.a.kW(9, this.CGO.computeSize());
      }
      i = paramInt;
      if (this.CGP != null) {
        i = paramInt + f.a.a.a.kW(10, this.CGP.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(11, this.DrF);
      AppMethodBeat.o(152567);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        if (this.CGH == null)
        {
          paramVarArgs = new b("Not all required fields were included: DnsInfo");
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqy localaqy = (aqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152567);
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
            localaqy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGH = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGI = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGJ = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGM = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 8: 
          localaqy.CGN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152567);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGO = ((pv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.CGP = ((pv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        }
        localaqy.DrF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152567);
        return 0;
      }
      AppMethodBeat.o(152567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqy
 * JD-Core Version:    0.7.0.1
 */