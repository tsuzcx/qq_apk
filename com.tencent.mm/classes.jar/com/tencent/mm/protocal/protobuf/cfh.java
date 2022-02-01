package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cfh
  extends erp
{
  public int IJG;
  public gol YOj;
  public String YQb;
  public String aaoV;
  public int aaoW;
  public b aaoX;
  public String appid;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104367);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.IJG);
      if (this.aaoV != null) {
        paramVarArgs.g(4, this.aaoV);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(5, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.aaoW);
      if (this.appid != null) {
        paramVarArgs.g(7, this.appid);
      }
      if (this.YQb != null) {
        paramVarArgs.g(8, this.YQb);
      }
      if (this.aaoX != null) {
        paramVarArgs.d(9, this.aaoX);
      }
      AppMethodBeat.o(104367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.aaoV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaoV);
      }
      i = paramInt;
      if (this.YOj != null) {
        i = paramInt + i.a.a.a.qC(5, this.YOj.computeSize());
      }
      i += i.a.a.b.b.a.cJ(6, this.aaoW);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.appid);
      }
      i = paramInt;
      if (this.YQb != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YQb);
      }
      paramInt = i;
      if (this.aaoX != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.aaoX);
      }
      AppMethodBeat.o(104367);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfh localcfh = (cfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104367);
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
            localcfh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 2: 
          localcfh.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104367);
          return 0;
        case 3: 
          localcfh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104367);
          return 0;
        case 4: 
          localcfh.aaoV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104367);
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
            localcfh.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 6: 
          localcfh.aaoW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104367);
          return 0;
        case 7: 
          localcfh.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104367);
          return 0;
        case 8: 
          localcfh.YQb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104367);
          return 0;
        }
        localcfh.aaoX = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(104367);
        return 0;
      }
      AppMethodBeat.o(104367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfh
 * JD-Core Version:    0.7.0.1
 */