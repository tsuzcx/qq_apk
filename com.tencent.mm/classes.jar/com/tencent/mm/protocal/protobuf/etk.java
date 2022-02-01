package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class etk
  extends com.tencent.mm.bx.a
{
  public int YAN;
  public long abWe;
  public bfv akjQ;
  public int akkK;
  public boolean akkL;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369679);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "msg_seq", Long.valueOf(this.abWe), false);
      com.tencent.mm.bk.a.a(localJSONObject, "box_id", this.akjQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "op_type", Integer.valueOf(this.YAN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "total_like_num", Integer.valueOf(this.akkK), false);
      com.tencent.mm.bk.a.a(localJSONObject, "is_show_like_num", Boolean.valueOf(this.akkL), false);
      label80:
      AppMethodBeat.o(369679);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369680);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abWe);
      if (this.akjQ != null)
      {
        paramVarArgs.qD(2, this.akjQ.computeSize());
        this.akjQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YAN);
      paramVarArgs.bS(4, this.akkK);
      paramVarArgs.di(5, this.akkL);
      AppMethodBeat.o(369680);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abWe) + 0;
      paramInt = i;
      if (this.akjQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.akjQ.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.YAN);
      int j = i.a.a.b.b.a.cJ(4, this.akkK);
      int k = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(369680);
      return paramInt + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(369680);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      etk localetk = (etk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(369680);
        return -1;
      case 1: 
        localetk.abWe = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(369680);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bfv localbfv = new bfv();
          if ((localObject != null) && (localObject.length > 0)) {
            localbfv.parseFrom((byte[])localObject);
          }
          localetk.akjQ = localbfv;
          paramInt += 1;
        }
        AppMethodBeat.o(369680);
        return 0;
      case 3: 
        localetk.YAN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(369680);
        return 0;
      case 4: 
        localetk.akkK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(369680);
        return 0;
      }
      localetk.akkL = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(369680);
      return 0;
    }
    AppMethodBeat.o(369680);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etk
 * JD-Core Version:    0.7.0.1
 */