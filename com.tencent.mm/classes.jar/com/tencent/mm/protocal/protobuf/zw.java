package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zw
  extends erp
{
  public String IMg;
  public String IMh;
  public String IcZ;
  public String Ida;
  public int YIE;
  public long YKr;
  public String YKs;
  public String ZaN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9586);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IMh != null) {
        paramVarArgs.g(2, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(3, this.IMg);
      }
      paramVarArgs.bv(4, this.YKr);
      if (this.ZaN != null) {
        paramVarArgs.g(5, this.ZaN);
      }
      if (this.Ida != null) {
        paramVarArgs.g(6, this.Ida);
      }
      paramVarArgs.bS(7, this.YIE);
      if (this.YKs != null) {
        paramVarArgs.g(8, this.YKs);
      }
      if (this.IcZ != null) {
        paramVarArgs.g(9, this.IcZ);
      }
      AppMethodBeat.o(9586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label755;
      }
    }
    label755:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IMh);
      }
      i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMg);
      }
      i += i.a.a.b.b.a.q(4, this.YKr);
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZaN);
      }
      i = paramInt;
      if (this.Ida != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Ida);
      }
      i += i.a.a.b.b.a.cJ(7, this.YIE);
      paramInt = i;
      if (this.YKs != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YKs);
      }
      i = paramInt;
      if (this.IcZ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.IcZ);
      }
      AppMethodBeat.o(9586);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(9586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        zw localzw = (zw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9586);
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
            localzw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(9586);
          return 0;
        case 2: 
          localzw.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 3: 
          localzw.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 4: 
          localzw.YKr = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(9586);
          return 0;
        case 5: 
          localzw.ZaN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 6: 
          localzw.Ida = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 7: 
          localzw.YIE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9586);
          return 0;
        case 8: 
          localzw.YKs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9586);
          return 0;
        }
        localzw.IcZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(9586);
        return 0;
      }
      AppMethodBeat.o(9586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zw
 * JD-Core Version:    0.7.0.1
 */