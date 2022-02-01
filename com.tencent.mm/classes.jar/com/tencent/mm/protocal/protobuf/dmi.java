package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dmi
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public all YKj;
  public String YOL;
  public gol YOj;
  public String YOy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.YKj == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(1, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      if (this.YKj != null)
      {
        paramVarArgs.qD(2, this.YKj.computeSize());
        this.YKj.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      if (this.YOy != null) {
        paramVarArgs.g(4, this.YOy);
      }
      if (this.YOL != null) {
        paramVarArgs.g(5, this.YOL);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YOj == null) {
        break label694;
      }
    }
    label694:
    for (int i = i.a.a.a.qC(1, this.YOj.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YKj != null) {
        paramInt = i + i.a.a.a.qC(2, this.YKj.computeSize());
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UserName);
      }
      paramInt = i;
      if (this.YOy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YOy);
      }
      i = paramInt;
      if (this.YOL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YOL);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.YKj == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dmi localdmi = (dmi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
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
            localdmi.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new all();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((all)localObject2).parseFrom((byte[])localObject1);
            }
            localdmi.YKj = ((all)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localdmi.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localdmi.YOy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localdmi.YOL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmi
 * JD-Core Version:    0.7.0.1
 */