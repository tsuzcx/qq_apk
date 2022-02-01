package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class err
  extends esc
{
  public String Hgk;
  public String JFk;
  public String OcM;
  public String OcN;
  public String YYi;
  public ep abvp;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.Hgk != null) {
        paramVarArgs.g(4, this.Hgk);
      }
      if (this.YYi != null) {
        paramVarArgs.g(5, this.YYi);
      }
      if (this.OcM != null) {
        paramVarArgs.g(6, this.OcM);
      }
      if (this.OcN != null) {
        paramVarArgs.g(7, this.OcN);
      }
      if (this.JFk != null) {
        paramVarArgs.g(8, this.JFk);
      }
      if (this.abvp != null)
      {
        paramVarArgs.qD(9, this.abvp.computeSize());
        this.abvp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.Hgk != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Hgk);
      }
      paramInt = i;
      if (this.YYi != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YYi);
      }
      i = paramInt;
      if (this.OcM != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.OcM);
      }
      paramInt = i;
      if (this.OcN != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.OcN);
      }
      i = paramInt;
      if (this.JFk != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.JFk);
      }
      paramInt = i;
      if (this.abvp != null) {
        paramInt = i + i.a.a.a.qC(9, this.abvp.computeSize());
      }
      AppMethodBeat.o(72582);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        err localerr = (err)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localerr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localerr.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localerr.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localerr.Hgk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localerr.YYi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localerr.OcM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localerr.OcN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localerr.JFk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ep();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ep)localObject2).parseFrom((byte[])localObject1);
          }
          localerr.abvp = ((ep)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.err
 * JD-Core Version:    0.7.0.1
 */