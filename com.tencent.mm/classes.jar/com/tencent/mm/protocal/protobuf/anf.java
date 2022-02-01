package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class anf
  extends com.tencent.mm.bx.a
{
  public bdm akfZ;
  public boolean akga;
  public boolean hJv;
  public int likeCount;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369673);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "source", this.akfZ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isLocal", Boolean.valueOf(this.hJv), false);
      com.tencent.mm.bk.a.a(localJSONObject, "likeCount", Integer.valueOf(this.likeCount), false);
      com.tencent.mm.bk.a.a(localJSONObject, "selfLike", Boolean.valueOf(this.akga), false);
      label66:
      AppMethodBeat.o(369673);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369674);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.akfZ != null)
      {
        paramVarArgs.qD(1, this.akfZ.computeSize());
        this.akfZ.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.hJv);
      paramVarArgs.bS(3, this.likeCount);
      paramVarArgs.di(4, this.akga);
      AppMethodBeat.o(369674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.akfZ == null) {
        break label416;
      }
    }
    label416:
    for (paramInt = i.a.a.a.qC(1, this.akfZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.likeCount);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(369674);
      return paramInt + (i + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(369674);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        anf localanf = (anf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(369674);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bdm localbdm = new bdm();
            if ((localObject != null) && (localObject.length > 0)) {
              localbdm.parseFrom((byte[])localObject);
            }
            localanf.akfZ = localbdm;
            paramInt += 1;
          }
          AppMethodBeat.o(369674);
          return 0;
        case 2: 
          localanf.hJv = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(369674);
          return 0;
        case 3: 
          localanf.likeCount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(369674);
          return 0;
        }
        localanf.akga = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(369674);
        return 0;
      }
      AppMethodBeat.o(369674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */