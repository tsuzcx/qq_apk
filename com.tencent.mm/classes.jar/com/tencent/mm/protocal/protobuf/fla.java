package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fla
  extends com.tencent.mm.bx.a
{
  public duk abLA;
  public int abLB;
  public int dataType;
  public String hIQ;
  public long oDh;
  public int oLx;
  public boolean oNH;
  public boolean oNP;
  public int scene;
  public int selector;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259125);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abLA != null)
      {
        paramVarArgs.qD(1, this.abLA.computeSize());
        this.abLA.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.oNH);
      paramVarArgs.bS(3, this.scene);
      paramVarArgs.bS(4, this.selector);
      paramVarArgs.di(5, this.oNP);
      paramVarArgs.bS(6, this.abLB);
      if (this.hIQ != null) {
        paramVarArgs.g(7, this.hIQ);
      }
      paramVarArgs.bS(8, this.dataType);
      paramVarArgs.bS(9, this.oLx);
      paramVarArgs.bv(10, this.oDh);
      AppMethodBeat.o(259125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abLA == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = i.a.a.a.qC(1, this.abLA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.scene) + i.a.a.b.b.a.cJ(4, this.selector) + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.cJ(6, this.abLB);
      paramInt = i;
      if (this.hIQ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.hIQ);
      }
      i = i.a.a.b.b.a.cJ(8, this.dataType);
      int j = i.a.a.b.b.a.cJ(9, this.oLx);
      int k = i.a.a.b.b.a.q(10, this.oDh);
      AppMethodBeat.o(259125);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259125);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fla localfla = (fla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259125);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            duk localduk = new duk();
            if ((localObject != null) && (localObject.length > 0)) {
              localduk.parseFrom((byte[])localObject);
            }
            localfla.abLA = localduk;
            paramInt += 1;
          }
          AppMethodBeat.o(259125);
          return 0;
        case 2: 
          localfla.oNH = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259125);
          return 0;
        case 3: 
          localfla.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259125);
          return 0;
        case 4: 
          localfla.selector = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259125);
          return 0;
        case 5: 
          localfla.oNP = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(259125);
          return 0;
        case 6: 
          localfla.abLB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259125);
          return 0;
        case 7: 
          localfla.hIQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259125);
          return 0;
        case 8: 
          localfla.dataType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259125);
          return 0;
        case 9: 
          localfla.oLx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259125);
          return 0;
        }
        localfla.oDh = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259125);
        return 0;
      }
      AppMethodBeat.o(259125);
      return -1;
    }
  }
  
  public final JSONObject toJSON()
  {
    AppMethodBeat.i(259126);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "response", this.abLA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shouldMergeKeyBuf", Boolean.valueOf(this.oNH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "selector", Integer.valueOf(this.selector), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isContinue", Boolean.valueOf(this.oNP), false);
      com.tencent.mm.bk.a.a(localJSONObject, "minSyncHashCode", Integer.valueOf(this.abLB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "dataId", this.hIQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "dataType", Integer.valueOf(this.dataType), false);
      com.tencent.mm.bk.a.a(localJSONObject, "pushSyncFlag", Integer.valueOf(this.oLx), false);
      com.tencent.mm.bk.a.a(localJSONObject, "recvTime", Long.valueOf(this.oDh), false);
      label147:
      AppMethodBeat.o(259126);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fla
 * JD-Core Version:    0.7.0.1
 */