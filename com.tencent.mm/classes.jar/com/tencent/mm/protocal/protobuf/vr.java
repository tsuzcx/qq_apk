package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vr
  extends cqk
{
  public String Bpa;
  public String DGU;
  public cek Eqb;
  public boolean Eqc;
  public int pAG;
  public String pAH;
  public String scene;
  public String session_id;
  public String token;
  
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(3, this.pAH);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.Eqb != null)
      {
        paramVarArgs.ln(5, this.Eqb.computeSize());
        this.Eqb.writeFields(paramVarArgs);
      }
      if (this.DGU != null) {
        paramVarArgs.d(6, this.DGU);
      }
      paramVarArgs.bl(7, this.Eqc);
      if (this.Bpa != null) {
        paramVarArgs.d(8, this.Bpa);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAH);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.Eqb != null) {
        paramInt = i + f.a.a.a.lm(5, this.Eqb.computeSize());
      }
      i = paramInt;
      if (this.DGU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DGU);
      }
      i += f.a.a.b.b.a.fK(7) + 1;
      paramInt = i;
      if (this.Bpa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Bpa);
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
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        vr localvr = (vr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91417);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 2: 
          localvr.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91417);
          return 0;
        case 3: 
          localvr.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 4: 
          localvr.token = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvr.Eqb = ((cek)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 6: 
          localvr.DGU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 7: 
          localvr.Eqc = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91417);
          return 0;
        case 8: 
          localvr.Bpa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 9: 
          localvr.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91417);
          return 0;
        }
        localvr.scene = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91417);
        return 0;
      }
      AppMethodBeat.o(91417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */