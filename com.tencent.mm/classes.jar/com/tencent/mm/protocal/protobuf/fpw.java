package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fpw
  extends erp
{
  public String Oiw;
  public String Oks;
  public String Okt;
  public long OmN;
  public String ZgS;
  public String abPH;
  public String abPp;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72605);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMy == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.Okt == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.Oks == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.Oiw == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hMy != null) {
        paramVarArgs.g(2, this.hMy);
      }
      if (this.Okt != null) {
        paramVarArgs.g(3, this.Okt);
      }
      if (this.Oks != null) {
        paramVarArgs.g(4, this.Oks);
      }
      if (this.Oiw != null) {
        paramVarArgs.g(5, this.Oiw);
      }
      paramVarArgs.bv(6, this.OmN);
      if (this.ZgS != null) {
        paramVarArgs.g(7, this.ZgS);
      }
      if (this.abPp != null) {
        paramVarArgs.g(8, this.abPp);
      }
      if (this.abPH != null) {
        paramVarArgs.g(9, this.abPH);
      }
      AppMethodBeat.o(72605);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label948;
      }
    }
    label948:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hMy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hMy);
      }
      i = paramInt;
      if (this.Okt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Okt);
      }
      paramInt = i;
      if (this.Oks != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Oks);
      }
      i = paramInt;
      if (this.Oiw != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Oiw);
      }
      i += i.a.a.b.b.a.q(6, this.OmN);
      paramInt = i;
      if (this.ZgS != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZgS);
      }
      i = paramInt;
      if (this.abPp != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abPp);
      }
      paramInt = i;
      if (this.abPH != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abPH);
      }
      AppMethodBeat.o(72605);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hMy == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.Okt == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.Oks == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.Oiw == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72605);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fpw localfpw = (fpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72605);
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
            localfpw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72605);
          return 0;
        case 2: 
          localfpw.hMy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 3: 
          localfpw.Okt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 4: 
          localfpw.Oks = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 5: 
          localfpw.Oiw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 6: 
          localfpw.OmN = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(72605);
          return 0;
        case 7: 
          localfpw.ZgS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 8: 
          localfpw.abPp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72605);
          return 0;
        }
        localfpw.abPH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72605);
        return 0;
      }
      AppMethodBeat.o(72605);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpw
 * JD-Core Version:    0.7.0.1
 */