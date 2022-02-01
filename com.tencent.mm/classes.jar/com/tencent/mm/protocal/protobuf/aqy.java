package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqy
  extends erp
{
  public String Njp;
  public int YIq;
  public float ZaG;
  public float ZaH;
  public String Zyk;
  public int Zyl;
  public String Zym;
  public String Zyn;
  public int Zyo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32207);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      if (this.Zyk != null) {
        paramVarArgs.g(3, this.Zyk);
      }
      paramVarArgs.l(4, this.ZaG);
      paramVarArgs.l(5, this.ZaH);
      paramVarArgs.bS(6, this.Zyl);
      if (this.Zym != null) {
        paramVarArgs.g(7, this.Zym);
      }
      if (this.Zyn != null) {
        paramVarArgs.g(8, this.Zyn);
      }
      paramVarArgs.bS(9, this.Zyo);
      if (this.Njp != null) {
        paramVarArgs.g(10, this.Njp);
      }
      AppMethodBeat.o(32207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq);
      paramInt = i;
      if (this.Zyk != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zyk);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 4) + (i.a.a.b.b.a.ko(5) + 4) + i.a.a.b.b.a.cJ(6, this.Zyl);
      paramInt = i;
      if (this.Zym != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zym);
      }
      i = paramInt;
      if (this.Zyn != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Zyn);
      }
      i += i.a.a.b.b.a.cJ(9, this.Zyo);
      paramInt = i;
      if (this.Njp != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Njp);
      }
      AppMethodBeat.o(32207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqy localaqy = (aqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32207);
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
            localaqy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32207);
          return 0;
        case 2: 
          localaqy.YIq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32207);
          return 0;
        case 3: 
          localaqy.Zyk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 4: 
          localaqy.ZaG = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(32207);
          return 0;
        case 5: 
          localaqy.ZaH = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(32207);
          return 0;
        case 6: 
          localaqy.Zyl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32207);
          return 0;
        case 7: 
          localaqy.Zym = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 8: 
          localaqy.Zyn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 9: 
          localaqy.Zyo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32207);
          return 0;
        }
        localaqy.Njp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32207);
        return 0;
      }
      AppMethodBeat.o(32207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqy
 * JD-Core Version:    0.7.0.1
 */