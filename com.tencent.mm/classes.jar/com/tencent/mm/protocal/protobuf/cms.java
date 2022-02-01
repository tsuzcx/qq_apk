package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cms
  extends erp
{
  public int Height;
  public int Width;
  public float ZaG;
  public float ZaH;
  public int aauu;
  public int aauv;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56247);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.l(2, this.ZaG);
      paramVarArgs.l(3, this.ZaH);
      paramVarArgs.bS(4, this.Width);
      paramVarArgs.bS(5, this.Height);
      if (this.yts != null) {
        paramVarArgs.g(6, this.yts);
      }
      paramVarArgs.bS(7, this.aauu);
      paramVarArgs.bS(8, this.aauv);
      AppMethodBeat.o(56247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 4) + (i.a.a.b.b.a.ko(3) + 4) + i.a.a.b.b.a.cJ(4, this.Width) + i.a.a.b.b.a.cJ(5, this.Height);
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.yts);
      }
      i = i.a.a.b.b.a.cJ(7, this.aauu);
      int j = i.a.a.b.b.a.cJ(8, this.aauv);
      AppMethodBeat.o(56247);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(56247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cms localcms = (cms)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56247);
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
            localcms.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(56247);
          return 0;
        case 2: 
          localcms.ZaG = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(56247);
          return 0;
        case 3: 
          localcms.ZaH = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(56247);
          return 0;
        case 4: 
          localcms.Width = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(56247);
          return 0;
        case 5: 
          localcms.Height = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(56247);
          return 0;
        case 6: 
          localcms.yts = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(56247);
          return 0;
        case 7: 
          localcms.aauu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(56247);
          return 0;
        }
        localcms.aauv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(56247);
        return 0;
      }
      AppMethodBeat.o(56247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cms
 * JD-Core Version:    0.7.0.1
 */