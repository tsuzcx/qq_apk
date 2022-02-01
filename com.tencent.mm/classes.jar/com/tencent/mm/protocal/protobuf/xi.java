package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xi
  extends erp
{
  public String OiN;
  public String Oiw;
  public String OjW;
  public String OjX;
  public String Okp;
  public String ZfW;
  public int amount;
  public String nickname;
  public String wwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.amount);
      if (this.wwH != null) {
        paramVarArgs.g(3, this.wwH);
      }
      if (this.Oiw != null) {
        paramVarArgs.g(4, this.Oiw);
      }
      if (this.ZfW != null) {
        paramVarArgs.g(5, this.ZfW);
      }
      if (this.OjW != null) {
        paramVarArgs.g(6, this.OjW);
      }
      if (this.OjX != null) {
        paramVarArgs.g(7, this.OjX);
      }
      if (this.Okp != null) {
        paramVarArgs.g(8, this.Okp);
      }
      if (this.nickname != null) {
        paramVarArgs.g(9, this.nickname);
      }
      if (this.OiN != null) {
        paramVarArgs.g(10, this.OiN);
      }
      AppMethodBeat.o(91400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label820;
      }
    }
    label820:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.amount);
      paramInt = i;
      if (this.wwH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wwH);
      }
      i = paramInt;
      if (this.Oiw != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Oiw);
      }
      paramInt = i;
      if (this.ZfW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZfW);
      }
      i = paramInt;
      if (this.OjW != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.OjW);
      }
      paramInt = i;
      if (this.OjX != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.OjX);
      }
      i = paramInt;
      if (this.Okp != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Okp);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.nickname);
      }
      i = paramInt;
      if (this.OiN != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.OiN);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        xi localxi = (xi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
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
            localxi.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localxi.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localxi.wwH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localxi.Oiw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localxi.ZfW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localxi.OjW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localxi.OjX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localxi.Okp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localxi.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localxi.OiN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xi
 * JD-Core Version:    0.7.0.1
 */