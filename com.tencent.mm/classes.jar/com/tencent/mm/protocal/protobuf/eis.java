package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eis
  extends erp
{
  public String UserName;
  public gol YJj;
  public int YOO;
  public gol YOj;
  public String aaSC;
  public String abag;
  public String vgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258679);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(258679);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.abag != null) {
        paramVarArgs.g(3, this.abag);
      }
      if (this.aaSC != null) {
        paramVarArgs.g(4, this.aaSC);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(5, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.YOO);
      if (this.vgW != null) {
        paramVarArgs.g(7, this.vgW);
      }
      if (this.YJj != null)
      {
        paramVarArgs.qD(8, this.YJj.computeSize());
        this.YJj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label888;
      }
    }
    label888:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.abag != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abag);
      }
      paramInt = i;
      if (this.aaSC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaSC);
      }
      i = paramInt;
      if (this.YOj != null) {
        i = paramInt + i.a.a.a.qC(5, this.YOj.computeSize());
      }
      i += i.a.a.b.b.a.cJ(6, this.YOO);
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.vgW);
      }
      i = paramInt;
      if (this.YJj != null) {
        i = paramInt + i.a.a.a.qC(8, this.YJj.computeSize());
      }
      AppMethodBeat.o(258679);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(258679);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258679);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eis localeis = (eis)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258679);
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
            localeis.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258679);
          return 0;
        case 2: 
          localeis.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258679);
          return 0;
        case 3: 
          localeis.abag = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258679);
          return 0;
        case 4: 
          localeis.aaSC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258679);
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
            localeis.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258679);
          return 0;
        case 6: 
          localeis.YOO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258679);
          return 0;
        case 7: 
          localeis.vgW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258679);
          return 0;
        }
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
          localeis.YJj = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258679);
        return 0;
      }
      AppMethodBeat.o(258679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eis
 * JD-Core Version:    0.7.0.1
 */