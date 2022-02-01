package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ave
  extends dyl
{
  public aqe RLM;
  public float latitude;
  public float longitude;
  public String object_nonce_id;
  public int scene;
  public String title;
  public String zDZ;
  public String zGK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      paramVarArgs.i(3, this.longitude);
      paramVarArgs.i(4, this.latitude);
      paramVarArgs.aY(5, this.scene);
      if (this.zDZ != null) {
        paramVarArgs.f(6, this.zDZ);
      }
      if (this.title != null) {
        paramVarArgs.f(7, this.title);
      }
      if (this.zGK != null) {
        paramVarArgs.f(8, this.zGK);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.f(9, this.object_nonce_id);
      }
      AppMethodBeat.o(230394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label800;
      }
    }
    label800:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLM != null) {
        i = paramInt + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = i + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4) + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.zDZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.zDZ);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.title);
      }
      paramInt = i;
      if (this.zGK != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.zGK);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.object_nonce_id);
      }
      AppMethodBeat.o(230394);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ave localave = (ave)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230394);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localave.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230394);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localave.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230394);
          return 0;
        case 3: 
          localave.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(230394);
          return 0;
        case 4: 
          localave.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(230394);
          return 0;
        case 5: 
          localave.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230394);
          return 0;
        case 6: 
          localave.zDZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230394);
          return 0;
        case 7: 
          localave.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230394);
          return 0;
        case 8: 
          localave.zGK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230394);
          return 0;
        }
        localave.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(230394);
        return 0;
      }
      AppMethodBeat.o(230394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ave
 * JD-Core Version:    0.7.0.1
 */