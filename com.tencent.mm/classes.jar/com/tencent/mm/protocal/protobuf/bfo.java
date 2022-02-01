package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bfo
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public LinkedList<String> ZPx;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public bfo()
  {
    AppMethodBeat.i(258347);
    this.ZPx = new LinkedList();
    AppMethodBeat.o(258347);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258349);
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
      paramVarArgs.bv(4, this.mMJ);
      paramVarArgs.bv(5, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(6, this.object_nonce_id);
      }
      paramVarArgs.bS(7, this.scene);
      if (this.YIZ != null) {
        paramVarArgs.g(8, this.YIZ);
      }
      paramVarArgs.e(9, 1, this.ZPx);
      AppMethodBeat.o(258349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
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
      i = i + i.a.a.b.b.a.q(4, this.mMJ) + i.a.a.b.b.a.q(5, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.object_nonce_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YIZ);
      }
      i = i.a.a.a.c(9, 1, this.ZPx);
      AppMethodBeat.o(258349);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZPx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bfo localbfo = (bfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258349);
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
            localbfo.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258349);
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
            localbfo.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258349);
          return 0;
        case 3: 
          localbfo.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258349);
          return 0;
        case 4: 
          localbfo.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258349);
          return 0;
        case 5: 
          localbfo.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258349);
          return 0;
        case 6: 
          localbfo.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258349);
          return 0;
        case 7: 
          localbfo.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258349);
          return 0;
        case 8: 
          localbfo.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258349);
          return 0;
        }
        localbfo.ZPx.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(258349);
        return 0;
      }
      AppMethodBeat.o(258349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfo
 * JD-Core Version:    0.7.0.1
 */