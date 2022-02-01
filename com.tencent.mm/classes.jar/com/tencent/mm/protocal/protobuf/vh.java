package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vh
  extends cld
{
  public bzm CXs;
  public boolean CXt;
  public String CoC;
  public int oXv;
  public String oXw;
  public String scene;
  public String session_id;
  public String token;
  public String zWG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91417);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.oXv);
      if (this.oXw != null) {
        paramVarArgs.d(3, this.oXw);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.CXs != null)
      {
        paramVarArgs.kX(5, this.CXs.computeSize());
        this.CXs.writeFields(paramVarArgs);
      }
      if (this.CoC != null) {
        paramVarArgs.d(6, this.CoC);
      }
      paramVarArgs.bg(7, this.CXt);
      if (this.zWG != null) {
        paramVarArgs.d(8, this.zWG);
      }
      if (this.session_id != null) {
        paramVarArgs.d(9, this.session_id);
      }
      if (this.scene != null) {
        paramVarArgs.d(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.oXv);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oXw);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.CXs != null) {
        paramInt = i + f.a.a.a.kW(5, this.CXs.computeSize());
      }
      i = paramInt;
      if (this.CoC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CoC);
      }
      i += f.a.a.b.b.a.fY(7) + 1;
      paramInt = i;
      if (this.zWG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.zWG);
      }
      i = paramInt;
      if (this.session_id != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.session_id);
      }
      paramInt = i;
      if (this.scene != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return paramInt;
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
          AppMethodBeat.o(91417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vh localvh = (vh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91417);
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
            localvh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 2: 
          localvh.oXv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91417);
          return 0;
        case 3: 
          localvh.oXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 4: 
          localvh.token = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvh.CXs = ((bzm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 6: 
          localvh.CoC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 7: 
          localvh.CXt = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91417);
          return 0;
        case 8: 
          localvh.zWG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 9: 
          localvh.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91417);
          return 0;
        }
        localvh.scene = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91417);
        return 0;
      }
      AppMethodBeat.o(91417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vh
 * JD-Core Version:    0.7.0.1
 */