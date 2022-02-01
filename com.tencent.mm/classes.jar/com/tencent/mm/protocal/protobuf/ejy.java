package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejy
  extends erp
{
  public int JaC;
  public String Oks;
  public int VaY;
  public String Vbl;
  public String ablH;
  public int abnw;
  public String abos;
  public int abot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91641);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abos != null) {
        paramVarArgs.g(2, this.abos);
      }
      if (this.Oks != null) {
        paramVarArgs.g(3, this.Oks);
      }
      paramVarArgs.bS(4, this.abnw);
      paramVarArgs.bS(5, this.JaC);
      if (this.ablH != null) {
        paramVarArgs.g(6, this.ablH);
      }
      paramVarArgs.bS(7, this.VaY);
      paramVarArgs.bS(8, this.abot);
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label736;
      }
    }
    label736:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abos != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abos);
      }
      i = paramInt;
      if (this.Oks != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Oks);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.abnw) + i.a.a.b.b.a.cJ(5, this.JaC);
      paramInt = i;
      if (this.ablH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ablH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.VaY) + i.a.a.b.b.a.cJ(8, this.abot);
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91641);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ejy localejy = (ejy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91641);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localejy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91641);
          return 0;
        case 2: 
          localejy.abos = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 3: 
          localejy.Oks = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 4: 
          localejy.abnw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91641);
          return 0;
        case 5: 
          localejy.JaC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91641);
          return 0;
        case 6: 
          localejy.ablH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 7: 
          localejy.VaY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91641);
          return 0;
        case 8: 
          localejy.abot = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91641);
          return 0;
        }
        localejy.Vbl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91641);
        return 0;
      }
      AppMethodBeat.o(91641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejy
 * JD-Core Version:    0.7.0.1
 */