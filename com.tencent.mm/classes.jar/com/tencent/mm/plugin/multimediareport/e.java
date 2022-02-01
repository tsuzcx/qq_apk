package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class e
  extends erp
{
  public LinkedList<a> Lih;
  public long Lii;
  public d Lij;
  public int scene;
  public long timestamp;
  
  public e()
  {
    AppMethodBeat.i(262702);
    this.Lih = new LinkedList();
    AppMethodBeat.o(262702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(262709);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.Lii);
      paramVarArgs.bv(3, this.timestamp);
      paramVarArgs.bS(4, this.scene);
      if (this.Lij != null)
      {
        paramVarArgs.qD(5, this.Lij.computeSize());
        this.Lij.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.Lih);
      AppMethodBeat.o(262709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Lii) + i.a.a.b.b.a.q(3, this.timestamp) + i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.Lij != null) {
        paramInt = i + i.a.a.a.qC(5, this.Lij.computeSize());
      }
      i = i.a.a.a.c(6, 8, this.Lih);
      AppMethodBeat.o(262709);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lih.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(262709);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(262709);
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
            locale.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(262709);
          return 0;
        case 2: 
          locale.Lii = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(262709);
          return 0;
        case 3: 
          locale.timestamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(262709);
          return 0;
        case 4: 
          locale.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(262709);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            locale.Lij = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(262709);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          locale.Lih.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(262709);
        return 0;
      }
      AppMethodBeat.o(262709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.e
 * JD-Core Version:    0.7.0.1
 */