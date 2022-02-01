package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class zf
  extends dpc
{
  public String HQm;
  public String KxE;
  public dal Lkx;
  public boolean Lky;
  public int rBL;
  public String rBM;
  public String scene;
  public String session_id;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91417);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(3, this.rBM);
      }
      if (this.token != null) {
        paramVarArgs.e(4, this.token);
      }
      if (this.Lkx != null)
      {
        paramVarArgs.ni(5, this.Lkx.computeSize());
        this.Lkx.writeFields(paramVarArgs);
      }
      if (this.KxE != null) {
        paramVarArgs.e(6, this.KxE);
      }
      paramVarArgs.cc(7, this.Lky);
      if (this.HQm != null) {
        paramVarArgs.e(8, this.HQm);
      }
      if (this.session_id != null) {
        paramVarArgs.e(9, this.session_id);
      }
      if (this.scene != null) {
        paramVarArgs.e(10, this.scene);
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
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBM);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.token);
      }
      paramInt = i;
      if (this.Lkx != null) {
        paramInt = i + g.a.a.a.nh(5, this.Lkx.computeSize());
      }
      i = paramInt;
      if (this.KxE != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KxE);
      }
      i += g.a.a.b.b.a.fS(7) + 1;
      paramInt = i;
      if (this.HQm != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.HQm);
      }
      i = paramInt;
      if (this.session_id != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.session_id);
      }
      paramInt = i;
      if (this.scene != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zf localzf = (zf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91417);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 2: 
          localzf.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91417);
          return 0;
        case 3: 
          localzf.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 4: 
          localzf.token = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dal();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dal)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzf.Lkx = ((dal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 6: 
          localzf.KxE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 7: 
          localzf.Lky = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91417);
          return 0;
        case 8: 
          localzf.HQm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 9: 
          localzf.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91417);
          return 0;
        }
        localzf.scene = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91417);
        return 0;
      }
      AppMethodBeat.o(91417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zf
 * JD-Core Version:    0.7.0.1
 */