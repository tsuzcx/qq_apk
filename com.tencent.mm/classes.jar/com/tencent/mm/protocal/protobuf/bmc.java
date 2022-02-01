package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmc
  extends cpx
{
  public String Fbu;
  public String Fbv;
  public int Fbw;
  public int Fbx;
  public String Fby;
  public String Fbz;
  public String djj;
  public int oxh;
  public String packageName;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.Fbu != null) {
        paramVarArgs.d(3, this.Fbu);
      }
      paramVarArgs.aR(4, this.scene);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.Fbv != null) {
        paramVarArgs.d(6, this.Fbv);
      }
      paramVarArgs.aR(7, this.oxh);
      paramVarArgs.aR(8, this.Fbw);
      paramVarArgs.aR(9, this.Fbx);
      if (this.Fby != null) {
        paramVarArgs.d(10, this.Fby);
      }
      if (this.packageName != null) {
        paramVarArgs.d(11, this.packageName);
      }
      if (this.Fbz != null) {
        paramVarArgs.d(12, this.Fbz);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.Fbu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fbu);
      }
      i += f.a.a.b.b.a.bx(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.Fbv != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fbv);
      }
      i = i + f.a.a.b.b.a.bx(7, this.oxh) + f.a.a.b.b.a.bx(8, this.Fbw) + f.a.a.b.b.a.bx(9, this.Fbx);
      paramInt = i;
      if (this.Fby != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fby);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.packageName);
      }
      paramInt = i;
      if (this.Fbz != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fbz);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmc localbmc = (bmc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localbmc.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localbmc.Fbu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localbmc.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localbmc.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localbmc.Fbv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localbmc.oxh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localbmc.Fbw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localbmc.Fbx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localbmc.Fby = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localbmc.packageName = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localbmc.Fbz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmc
 * JD-Core Version:    0.7.0.1
 */