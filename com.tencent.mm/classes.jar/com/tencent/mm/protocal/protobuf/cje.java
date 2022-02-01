package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class cje
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public b ZEQ;
  public bfv akjQ;
  public long mMJ;
  public long object_id;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369682);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseRequest", this.BaseRequest, false);
      com.tencent.mm.bk.a.a(localJSONObject, "finder_basereq", this.YIY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "live_cookies", this.YJa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "box_id", this.akjQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "last_buffer", this.ZEQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "object_id", Long.valueOf(this.object_id), false);
      com.tencent.mm.bk.a.a(localJSONObject, "live_id", Long.valueOf(this.mMJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "finder_username", this.YIZ, false);
      label107:
      AppMethodBeat.o(369682);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label107;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369683);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(3, this.YJa);
      }
      if (this.akjQ != null)
      {
        paramVarArgs.qD(4, this.akjQ.computeSize());
        this.akjQ.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(5, this.ZEQ);
      }
      paramVarArgs.bv(6, this.object_id);
      paramVarArgs.bv(7, this.mMJ);
      if (this.YIZ != null) {
        paramVarArgs.g(8, this.YIZ);
      }
      AppMethodBeat.o(369683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label820;
      }
    }
    label820:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YJa);
      }
      paramInt = i;
      if (this.akjQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.akjQ.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.ZEQ);
      }
      i = i + i.a.a.b.b.a.q(6, this.object_id) + i.a.a.b.b.a.q(7, this.mMJ);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YIZ);
      }
      AppMethodBeat.o(369683);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(369683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cje localcje = (cje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(369683);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcje.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369683);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localcje.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369683);
          return 0;
        case 3: 
          localcje.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(369683);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfv)localObject2).parseFrom((byte[])localObject1);
            }
            localcje.akjQ = ((bfv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369683);
          return 0;
        case 5: 
          localcje.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(369683);
          return 0;
        case 6: 
          localcje.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(369683);
          return 0;
        case 7: 
          localcje.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(369683);
          return 0;
        }
        localcje.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(369683);
        return 0;
      }
      AppMethodBeat.o(369683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cje
 * JD-Core Version:    0.7.0.1
 */