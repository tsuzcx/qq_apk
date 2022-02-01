package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aqe
  extends erp
{
  public String Zxu;
  public String Zxv;
  public long Zxw;
  public double Zxx;
  public double Zxy;
  public b Zxz;
  public String city;
  public String province;
  public String ytZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ytZ != null) {
        paramVarArgs.g(2, this.ytZ);
      }
      if (this.city != null) {
        paramVarArgs.g(3, this.city);
      }
      if (this.province != null) {
        paramVarArgs.g(4, this.province);
      }
      if (this.Zxu != null) {
        paramVarArgs.g(5, this.Zxu);
      }
      if (this.Zxv != null) {
        paramVarArgs.g(6, this.Zxv);
      }
      paramVarArgs.bv(7, this.Zxw);
      paramVarArgs.d(8, this.Zxx);
      paramVarArgs.d(9, this.Zxy);
      if (this.Zxz != null) {
        paramVarArgs.d(10, this.Zxz);
      }
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ytZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ytZ);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.city);
      }
      paramInt = i;
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.province);
      }
      i = paramInt;
      if (this.Zxu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zxu);
      }
      paramInt = i;
      if (this.Zxv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zxv);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.Zxw) + (i.a.a.b.b.a.ko(8) + 8) + (i.a.a.b.b.a.ko(9) + 8);
      paramInt = i;
      if (this.Zxz != null) {
        paramInt = i + i.a.a.b.b.a.c(10, this.Zxz);
      }
      AppMethodBeat.o(91452);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqe localaqe = (aqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
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
            localaqe.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localaqe.ytZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localaqe.city = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localaqe.province = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localaqe.Zxu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localaqe.Zxv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localaqe.Zxw = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localaqe.Zxx = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(91452);
          return 0;
        case 9: 
          localaqe.Zxy = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(91452);
          return 0;
        }
        localaqe.Zxz = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqe
 * JD-Core Version:    0.7.0.1
 */