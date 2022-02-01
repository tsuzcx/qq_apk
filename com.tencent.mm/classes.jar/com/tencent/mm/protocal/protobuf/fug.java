package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fug
  extends erp
{
  public int IJG;
  public String IMg;
  public String IMh;
  public gol NkQ;
  public String YWC;
  public fzc ZkE;
  public fuf ZkG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32487);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZkE == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.ZkG == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YWC != null) {
        paramVarArgs.g(2, this.YWC);
      }
      if (this.ZkE != null)
      {
        paramVarArgs.qD(3, this.ZkE.computeSize());
        this.ZkE.writeFields(paramVarArgs);
      }
      if (this.ZkG != null)
      {
        paramVarArgs.qD(4, this.ZkG.computeSize());
        this.ZkG.writeFields(paramVarArgs);
      }
      if (this.NkQ != null)
      {
        paramVarArgs.qD(5, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.IJG);
      if (this.IMh != null) {
        paramVarArgs.g(7, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(8, this.IMg);
      }
      AppMethodBeat.o(32487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1076;
      }
    }
    label1076:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YWC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YWC);
      }
      i = paramInt;
      if (this.ZkE != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZkE.computeSize());
      }
      paramInt = i;
      if (this.ZkG != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZkG.computeSize());
      }
      i = paramInt;
      if (this.NkQ != null) {
        i = paramInt + i.a.a.a.qC(5, this.NkQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(6, this.IJG);
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IMh);
      }
      i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.IMg);
      }
      AppMethodBeat.o(32487);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZkE == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.ZkG == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fug localfug = (fug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32487);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfug.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 2: 
          localfug.YWC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32487);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzc)localObject2).parseFrom((byte[])localObject1);
            }
            localfug.ZkE = ((fzc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fuf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fuf)localObject2).parseFrom((byte[])localObject1);
            }
            localfug.ZkG = ((fuf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfug.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 6: 
          localfug.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32487);
          return 0;
        case 7: 
          localfug.IMh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32487);
          return 0;
        }
        localfug.IMg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32487);
        return 0;
      }
      AppMethodBeat.o(32487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fug
 * JD-Core Version:    0.7.0.1
 */