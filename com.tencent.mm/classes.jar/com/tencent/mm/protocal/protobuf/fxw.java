package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fxw
  extends com.tencent.mm.bx.a
{
  public String abVA;
  public agg abVx;
  public boolean abVy = true;
  public fxg abVz;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257905);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ContentId", this.abVx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Valid", Boolean.valueOf(this.abVy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "VideoCdnInfo", this.abVz, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VideoApi", this.abVA, false);
      label60:
      AppMethodBeat.o(257905);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abVx != null)
      {
        paramVarArgs.qD(1, this.abVx.computeSize());
        this.abVx.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.abVy);
      if (this.abVz != null)
      {
        paramVarArgs.qD(3, this.abVz.computeSize());
        this.abVz.writeFields(paramVarArgs);
      }
      if (this.abVA != null) {
        paramVarArgs.g(4, this.abVA);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abVx == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = i.a.a.a.qC(1, this.abVx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.abVz != null) {
        paramInt = i + i.a.a.a.qC(3, this.abVz.computeSize());
      }
      i = paramInt;
      if (this.abVA != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abVA);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fxw localfxw = (fxw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new agg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((agg)localObject2).parseFrom((byte[])localObject1);
            }
            localfxw.abVx = ((agg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localfxw.abVy = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxg)localObject2).parseFrom((byte[])localObject1);
            }
            localfxw.abVz = ((fxg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localfxw.abVA = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxw
 * JD-Core Version:    0.7.0.1
 */