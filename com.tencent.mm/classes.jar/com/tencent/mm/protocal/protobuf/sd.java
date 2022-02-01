package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class sd
  extends erp
{
  public String Oiw;
  public String Oln;
  public String YGt;
  public String YGu;
  public int YGv;
  public b YXb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YGt != null) {
        paramVarArgs.g(2, this.YGt);
      }
      if (this.Oln != null) {
        paramVarArgs.g(3, this.Oln);
      }
      if (this.Oiw != null) {
        paramVarArgs.g(4, this.Oiw);
      }
      paramVarArgs.bS(5, this.YGv);
      if (this.YXb != null) {
        paramVarArgs.d(6, this.YXb);
      }
      if (this.YGu != null) {
        paramVarArgs.g(7, this.YGu);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGt);
      }
      i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Oln);
      }
      paramInt = i;
      if (this.Oiw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Oiw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YGv);
      paramInt = i;
      if (this.YXb != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.YXb);
      }
      i = paramInt;
      if (this.YGu != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YGu);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        sd localsd = (sd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
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
            localsd.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localsd.YGt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localsd.Oln = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localsd.Oiw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localsd.YGv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localsd.YXb = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(91365);
          return 0;
        }
        localsd.YGu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */