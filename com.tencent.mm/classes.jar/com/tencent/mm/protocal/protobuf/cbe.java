package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cbe
  extends esc
{
  public String Ide;
  public LinkedList<String> aakr;
  public LinkedList<String> aaks;
  public LinkedList<String> aakt;
  public LinkedList<cbf> aaku;
  public String hAP;
  
  public cbe()
  {
    AppMethodBeat.i(42635);
    this.aakr = new LinkedList();
    this.aaks = new LinkedList();
    this.aakt = new LinkedList();
    this.aaku = new LinkedList();
    AppMethodBeat.o(42635);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42636);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.Ide == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      paramVarArgs.e(3, 1, this.aakr);
      if (this.Ide != null) {
        paramVarArgs.g(4, this.Ide);
      }
      paramVarArgs.e(5, 1, this.aaks);
      paramVarArgs.e(6, 1, this.aakt);
      paramVarArgs.e(7, 8, this.aaku);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hAP);
      }
      i += i.a.a.a.c(3, 1, this.aakr);
      paramInt = i;
      if (this.Ide != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Ide);
      }
      i = i.a.a.a.c(5, 1, this.aaks);
      int j = i.a.a.a.c(6, 1, this.aakt);
      int k = i.a.a.a.c(7, 8, this.aaku);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aakr.clear();
        this.aaks.clear();
        this.aakt.clear();
        this.aaku.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        if (this.Ide == null)
        {
          paramVarArgs = new b("Not all required fields were included: JsonData");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cbe localcbe = (cbe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
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
            localcbe.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localcbe.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localcbe.aakr.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localcbe.Ide = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localcbe.aaks.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localcbe.aakt.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cbf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cbf)localObject2).parseFrom((byte[])localObject1);
          }
          localcbe.aaku.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(42636);
        return 0;
      }
      AppMethodBeat.o(42636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbe
 * JD-Core Version:    0.7.0.1
 */