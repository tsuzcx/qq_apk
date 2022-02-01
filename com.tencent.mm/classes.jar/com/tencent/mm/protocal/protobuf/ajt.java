package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajt
  extends erp
{
  public int YDV;
  public String Zra;
  public int Zrb;
  public String appid;
  public int group_id;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147761);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.Zra != null) {
        paramVarArgs.g(3, this.Zra);
      }
      paramVarArgs.bS(4, this.group_id);
      paramVarArgs.bS(5, this.source);
      paramVarArgs.bS(6, this.Zrb);
      paramVarArgs.bS(7, this.YDV);
      AppMethodBeat.o(147761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.Zra != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zra);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.group_id);
      int j = i.a.a.b.b.a.cJ(5, this.source);
      int k = i.a.a.b.b.a.cJ(6, this.Zrb);
      int m = i.a.a.b.b.a.cJ(7, this.YDV);
      AppMethodBeat.o(147761);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ajt localajt = (ajt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147761);
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
            localajt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(147761);
          return 0;
        case 2: 
          localajt.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 3: 
          localajt.Zra = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 4: 
          localajt.group_id = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147761);
          return 0;
        case 5: 
          localajt.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147761);
          return 0;
        case 6: 
          localajt.Zrb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147761);
          return 0;
        }
        localajt.YDV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(147761);
        return 0;
      }
      AppMethodBeat.o(147761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajt
 * JD-Core Version:    0.7.0.1
 */