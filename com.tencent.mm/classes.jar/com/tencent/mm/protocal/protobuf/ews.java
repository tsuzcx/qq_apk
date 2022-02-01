package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ews
  extends erp
{
  public int YWM;
  public String YYZ;
  public String ZlZ;
  public String abyT;
  public String appid;
  public int scene;
  public int source;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91683);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZlZ != null) {
        paramVarArgs.g(2, this.ZlZ);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      if (this.abyT != null) {
        paramVarArgs.g(5, this.abyT);
      }
      paramVarArgs.bS(6, this.scene);
      paramVarArgs.bS(7, this.source);
      if (this.YYZ != null) {
        paramVarArgs.g(8, this.YYZ);
      }
      paramVarArgs.bS(9, this.YWM);
      AppMethodBeat.o(91683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label724;
      }
    }
    label724:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZlZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZlZ);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt;
      if (this.abyT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abyT);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.scene) + i.a.a.b.b.a.cJ(7, this.source);
      paramInt = i;
      if (this.YYZ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YYZ);
      }
      i = i.a.a.b.b.a.cJ(9, this.YWM);
      AppMethodBeat.o(91683);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ews localews = (ews)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91683);
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
            localews.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91683);
          return 0;
        case 2: 
          localews.ZlZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 3: 
          localews.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 4: 
          localews.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 5: 
          localews.abyT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 6: 
          localews.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91683);
          return 0;
        case 7: 
          localews.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91683);
          return 0;
        case 8: 
          localews.YYZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91683);
          return 0;
        }
        localews.YWM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91683);
        return 0;
      }
      AppMethodBeat.o(91683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ews
 * JD-Core Version:    0.7.0.1
 */