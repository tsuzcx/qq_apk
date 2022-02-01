package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class blo
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public String ZKq;
  public LinkedList<String> ZUF;
  public long mMJ;
  public long object_id;
  public String request_id;
  
  public blo()
  {
    AppMethodBeat.i(259172);
    this.ZUF = new LinkedList();
    AppMethodBeat.o(259172);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259176);
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
      paramVarArgs.bv(3, this.object_id);
      paramVarArgs.bv(4, this.mMJ);
      paramVarArgs.e(5, 1, this.ZUF);
      if (this.ZKq != null) {
        paramVarArgs.g(6, this.ZKq);
      }
      if (this.YJa != null) {
        paramVarArgs.d(7, this.YJa);
      }
      if (this.request_id != null) {
        paramVarArgs.g(8, this.request_id);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(9, this.YIZ);
      }
      AppMethodBeat.o(259176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.object_id) + i.a.a.b.b.a.q(4, this.mMJ) + i.a.a.a.c(5, 1, this.ZUF);
      paramInt = i;
      if (this.ZKq != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZKq);
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.YJa);
      }
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.request_id);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YIZ);
      }
      AppMethodBeat.o(259176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZUF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        blo localblo = (blo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259176);
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
            localblo.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259176);
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
            localblo.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259176);
          return 0;
        case 3: 
          localblo.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259176);
          return 0;
        case 4: 
          localblo.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259176);
          return 0;
        case 5: 
          localblo.ZUF.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259176);
          return 0;
        case 6: 
          localblo.ZKq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259176);
          return 0;
        case 7: 
          localblo.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259176);
          return 0;
        case 8: 
          localblo.request_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259176);
          return 0;
        }
        localblo.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259176);
        return 0;
      }
      AppMethodBeat.o(259176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blo
 * JD-Core Version:    0.7.0.1
 */