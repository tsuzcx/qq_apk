package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ew
  extends com.tencent.mm.bw.a
{
  public boolean DRA;
  public LinkedList<dht> DRB;
  public int DRs;
  public String DRt;
  public int DRu;
  public boolean DRv;
  public int DRw;
  public int DRx;
  public int DRy;
  public int DRz;
  public String Url;
  public int hkQ;
  public String hkR;
  public int vTO;
  
  public ew()
  {
    AppMethodBeat.i(6388);
    this.DRs = 600;
    this.hkQ = -1;
    this.DRA = false;
    this.DRB = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      if (this.hkR != null) {
        paramVarArgs.d(2, this.hkR);
      }
      paramVarArgs.aR(3, this.DRs);
      if (this.DRt != null) {
        paramVarArgs.d(4, this.DRt);
      }
      paramVarArgs.aR(5, this.DRu);
      paramVarArgs.bl(6, this.DRv);
      paramVarArgs.aR(7, this.DRw);
      paramVarArgs.aR(8, this.DRx);
      paramVarArgs.aR(9, this.vTO);
      paramVarArgs.aR(10, this.DRy);
      paramVarArgs.aR(11, this.DRz);
      paramVarArgs.aR(12, this.hkQ);
      paramVarArgs.bl(13, this.DRA);
      paramVarArgs.e(14, 8, this.DRB);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hkR);
      }
      i += f.a.a.b.b.a.bx(3, this.DRs);
      paramInt = i;
      if (this.DRt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DRt);
      }
      i = f.a.a.b.b.a.bx(5, this.DRu);
      int j = f.a.a.b.b.a.fK(6);
      int k = f.a.a.b.b.a.bx(7, this.DRw);
      int m = f.a.a.b.b.a.bx(8, this.DRx);
      int n = f.a.a.b.b.a.bx(9, this.vTO);
      int i1 = f.a.a.b.b.a.bx(10, this.DRy);
      int i2 = f.a.a.b.b.a.bx(11, this.DRz);
      int i3 = f.a.a.b.b.a.bx(12, this.hkQ);
      int i4 = f.a.a.b.b.a.fK(13);
      int i5 = f.a.a.a.c(14, 8, this.DRB);
      AppMethodBeat.o(6389);
      return paramInt + i + (j + 1) + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ew localew = (ew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localew.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localew.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localew.DRs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localew.DRt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localew.DRu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localew.DRv = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localew.DRw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localew.DRx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localew.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localew.DRy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localew.DRz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localew.hkQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localew.DRA = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localew.DRB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ew
 * JD-Core Version:    0.7.0.1
 */